CREATE SCHEMA IF NOT EXISTS bank;

SET search_path TO bank;

CREATE TABLE persona (
                         id UUID PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         genero VARCHAR(20),
                         edad INTEGER,
                         identificacion VARCHAR(50) UNIQUE NOT NULL,
                         direccion VARCHAR(255),
                         telefono VARCHAR(20)
);

CREATE TABLE cliente (
                         id UUID PRIMARY KEY,
                         password VARCHAR(255) NOT NULL,
                         cliente_id VARCHAR(50) UNIQUE NOT NULL,
                         estado BOOLEAN NOT NULL,
                         CONSTRAINT fk_cliente_persona
                             FOREIGN KEY (id)
                                 REFERENCES persona(id)
                                 ON DELETE CASCADE
);

CREATE TABLE cuenta (
                        id UUID PRIMARY KEY,
                        numero_cuenta VARCHAR(20) UNIQUE NOT NULL,
                        tipo VARCHAR(20) NOT NULL,
                        saldo_inicial NUMERIC(15,2) NOT NULL,
                        saldo_actual NUMERIC(15,2) NOT NULL,
                        estado BOOLEAN NOT NULL,
                        cliente_id UUID NOT NULL,
                        CONSTRAINT fk_cuenta_cliente
                            FOREIGN KEY (cliente_id)
                                REFERENCES cliente(id)
                                ON DELETE CASCADE
);

CREATE INDEX idx_cuenta_cliente ON cuenta(cliente_id);

CREATE TABLE movimiento (
                            id UUID PRIMARY KEY,
                            cuenta_id UUID NOT NULL,
                            fecha TIMESTAMP NOT NULL,
                            tipo VARCHAR(20) NOT NULL,
                            valor NUMERIC(15,2) NOT NULL,
                            saldo_resultante NUMERIC(15,2) NOT NULL,
                            CONSTRAINT fk_movimiento_cuenta
                                FOREIGN KEY (cuenta_id)
                                    REFERENCES cuenta(id)
                                    ON DELETE CASCADE
);

CREATE INDEX idx_movimiento_cuenta ON movimiento(cuenta_id);
CREATE INDEX idx_movimiento_fecha ON movimiento(fecha);

-- MOCK PERSONA
INSERT INTO persona (id, nombre, genero, edad, identificacion, direccion, telefono)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'Juan Perez', 'M', 30, '123456', 'Calle 1', '555-1234'),
    ('22222222-2222-2222-2222-222222222222', 'Maria Lopez', 'F', 28, '654321', 'Calle 2', '555-5678');

-- MOCK CLIENTE
INSERT INTO cliente (id, password, cliente_id, estado)
VALUES
    ('11111111-1111-1111-1111-111111111111', '1234', 'CLI-001', true),
    ('22222222-2222-2222-2222-222222222222', '1234', 'CLI-002', true);

-- MOCK CUENTA
INSERT INTO cuenta (id, numero_cuenta, tipo, saldo_inicial, saldo_actual, estado, cliente_id)
VALUES
    ('33333333-3333-3333-3333-333333333333', 'ACC-001', 'AHORROS', 1000, 1200, true, '11111111-1111-1111-1111-111111111111'),
    ('44444444-4444-4444-4444-444444444444', 'ACC-002', 'CORRIENTE', 2000, 1800, true, '22222222-2222-2222-2222-222222222222');

-- MOCK MOVIMIENTOS
INSERT INTO movimiento (id, cuenta_id, fecha, tipo, valor, saldo_resultante)
VALUES
    ('55555555-5555-5555-5555-555555555555', '33333333-3333-3333-3333-333333333333', NOW(), 'DEPOSITO', 200, 1200),
    ('66666666-6666-6666-6666-666666666666', '44444444-4444-4444-4444-444444444444', NOW(), 'RETIRO', -200, 1800);