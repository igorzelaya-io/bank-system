export interface CuentaResponse {
  id: string;
  numeroCuenta: string;
  tipo: string;
  saldoInicial: number;
  saldoActual: number;
  estado: boolean;
  clienteId: string;
}
