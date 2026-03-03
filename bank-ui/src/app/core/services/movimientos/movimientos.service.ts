import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovimientosService {

  constructor(private http: HttpClient) {}

  searchMovimientos(clienteId: string): Observable<any[]> {
    return this.http.get<any[]>(`/api/v1/movimientos?clienteId=${clienteId}`);
  }
}
