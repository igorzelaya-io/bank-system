import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportesService {

  constructor(private http: HttpClient) {}

  getReport(clienteId: string, from: Date, to: Date): Observable<any> {
    const fromStr = from.toISOString();
    const toStr = to.toISOString();
    return this.http.get<any>(`/api/report?clienteId=${clienteId}&from=${fromStr}&to=${toStr}`);
  }

  getReportPdf(clienteId: string, from: Date, to: Date): Observable<Blob> {
    const fromStr = from.toISOString();
    const toStr = to.toISOString();
    return this.http.get(`/api/report/pdf?clienteId=${clienteId}&from=${fromStr}&to=${toStr}`, { responseType: 'blob' });
  }
}
