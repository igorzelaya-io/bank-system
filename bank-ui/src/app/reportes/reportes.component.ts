import { Component, OnInit } from '@angular/core';
import { ReportesService } from '../core/services/reportes/reportes.service';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatButtonModule} from '@angular/material/button';

@Component({
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule
  ],
  standalone: true,
  selector: 'app-reportes',
  templateUrl: './reportes.component.html',
  styleUrls: ['./reportes.component.css']
})
export class ReportesComponent implements OnInit {

  clienteId: string = '';
  from: Date | null = null;
  to: Date | null = null;

  report: any = null;

  constructor(private reportesService: ReportesService) {}

  ngOnInit(): void {}

  onSearch(): void {
    if (!this.clienteId || !this.from || !this.to) return;

    this.reportesService.getReport(this.clienteId, this.from, this.to)
      .subscribe(res => this.report = res);
  }

  onDownloadPdf(): void {
    if (!this.clienteId || !this.from || !this.to) return;

    this.reportesService.getReportPdf(this.clienteId, this.from, this.to)
      .subscribe(blob => {
        const url = (window as any).URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = 'report.pdf';
        a.click();
        (window as any).URL.revokeObjectURL(url);
      });
  }
}
