import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CuentaResponse} from '../../models/CuentaResponse';

@Injectable({
  providedIn: 'root'
})
export class CuentasService {
  constructor(private http: HttpClient) {

  }
  searchCuentas(term: string): Observable<CuentaResponse[]> {
    return this.http.get<CuentaResponse[]>(`/api/v1/cuentas?search=${term}`);
  }
}
