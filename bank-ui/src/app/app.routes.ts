
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientesComponent } from './clientes/clientes.component';
import { CuentasComponent } from './cuentas/cuentas.component';
import { MovimientosComponent } from './movimientos/movimientos.component';
import { ReportesComponent } from './reportes/reportes.component';

export const routes: Routes = [
  { path: 'clientes', component: ClientesComponent },
  { path: 'cuentas', component: CuentasComponent },
  { path: 'movimientos', component: MovimientosComponent },
  { path: 'reportes', component: ReportesComponent },
  { path: '', redirectTo: '/clientes', pathMatch: 'full' },
  { path: '**', redirectTo: '/clientes' }
];
