import {Component, OnInit} from '@angular/core';
import {ClientesService} from '../core/services/clientes/clientes.service';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './clientes.component.html',
  styleUrl: './clientes.component.css'
})
export class ClientesComponent implements OnInit {

  clientes: any[] = [];
  searchTerm: string = '';

  constructor(private clientesService: ClientesService) {}

  ngOnInit(): void {
    this.loadClientes();
  }

  loadClientes(): void {
    this.clientesService.searchClientes(this.searchTerm)
      .subscribe(res => this.clientes = res);
  }

  onSearch(): void {
    this.loadClientes();
  }

  onAddCliente(): void {
    // Implement modal / navigation to form later
    alert('Add Cliente clicked');
  }
}
