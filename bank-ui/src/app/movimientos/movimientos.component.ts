import {Component, OnInit} from '@angular/core';
import {MovimientosService} from '../core/services/movimientos/movimientos.service';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  imports: [
    CommonModule,
    FormsModule
  ],
  standalone: true,
  selector: 'app-movimientos',
  templateUrl: './movimientos.component.html',
  styleUrls: ['./movimientos.component.css']
})
export class MovimientosComponent implements OnInit {

  movimientos: any[] = [];
  clienteId: string = '';

  constructor(private movimientosService: MovimientosService) {}

  ngOnInit(): void {
    // Optionally preload movements for a default cliente
  }

  loadMovimientos(): void {
    if(!this.clienteId) return;
    this.movimientosService.searchMovimientos(this.clienteId)
      .subscribe(res => this.movimientos = res);
  }

  onSearch(): void {
    this.loadMovimientos();
  }

  onAddMovimiento(): void {
    alert('Add Movimiento clicked');
  }
}
