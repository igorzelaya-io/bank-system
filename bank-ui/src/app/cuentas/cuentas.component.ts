
import { Component, OnInit } from '@angular/core';
import { CuentasService } from '../core/services/cuentas/cuentas.service';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  imports: [CommonModule, FormsModule],
  standalone: true,
  selector: 'app-cuentas',
  templateUrl: './cuentas.component.html',
  styleUrls: ['./cuentas.component.css']
})
export class CuentasComponent implements OnInit {

  cuentas: any[] = [];
  searchTerm: string = '';

  constructor(private cuentasService: CuentasService) {}

  ngOnInit(): void {
    this.loadCuentas();
  }

  loadCuentas(): void {
    this.cuentasService.searchCuentas(this.searchTerm)
      .subscribe(res => this.cuentas = res);
  }

  onSearch(): void {
    this.loadCuentas();
  }

  onAddCuenta(): void {
    alert('Add Cuenta clicked');
    // Later: open modal or navigate to create form
  }
}
