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