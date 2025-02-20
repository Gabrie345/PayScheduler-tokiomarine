import { Component, Inject, ViewChild, AfterViewInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { ApiService } from '../service/api.service';

interface TaxModel {
  id: number;
  maxDays: number;
  minDays: number;
  tax: number;
  value: number;
}

interface Transfer {
  id: number;
  appointmentDate: string;  
  dateTransfer: string;
  destinationAccount: string;
  originAccount: string;
  value: number;
  taxModel: TaxModel;
  tax?: number; 
  totalValue?: number; 
}

@Component({
  selector: 'app-transfer-modal',
  templateUrl: './transfer-modal.component.html',
  styleUrls: ['./transfer-modal.component.css'],
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatPaginatorModule,
    MatDialogModule
  ]
})

export class TransferModalComponent implements AfterViewInit {
  displayedColumns: string[] = ['appointmentDate', 'dateTransfer', 'destinationAccount', 'tax', 'totalValue'];
  dataSource = new MatTableDataSource<Transfer>([]);
  totalItems = 0;
  pageSize = 5;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    public dialogRef: MatDialogRef<TransferModalComponent>,
    private apiService: ApiService,
    @Inject(MAT_DIALOG_DATA) public data: { account: string }
  ) {

  }
  ngAfterViewInit() {
    this.request(this.data.account)
    this.dataSource.paginator = this.paginator;
  }

  request(account: string): void {
    this.apiService.listTransfers(account).subscribe(
      response => {
        this.dataSource.data = response.map((item: Transfer) => ({
          ...item,
          dateTransfer: this.convertDate(item.dateTransfer),
          appointmentDate: this.convertDate(item.appointmentDate),
          tax: item.taxModel.tax, 
          totalValue: item.value + item.taxModel.value 
        }));
        this.totalItems = response.length; 
      },
      error => {
        this.dialogRef.close();
      }
    );
  }
  
  convertDate(dateStr: string): Date {
    const [day, month, year] = dateStr.split('/').map(Number);
    return new Date(year, month - 1, day); 
  }
  onPageChange(event: PageEvent): void {
    this.pageSize = event.pageSize;
  }

  close(): void {
    this.dialogRef.close();
  }
}