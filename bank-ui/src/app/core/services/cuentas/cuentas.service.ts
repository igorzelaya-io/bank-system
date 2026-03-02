import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CuentasService {
  constructor(private http: HttpClient) {}
  searchCuentas(term: string): Observable<any[]> {
    // Uses the same proxy config as before
    return this.http.get<any[]>(`/api/cuentas?search=${term}`);
  }
}
