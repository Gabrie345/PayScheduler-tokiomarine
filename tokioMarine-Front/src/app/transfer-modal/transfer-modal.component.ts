import { Component, Inject, ViewChild, AfterViewInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialogModule } from '@angular/material/dialog';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';

// Interface para tipagem dos dados
interface Transfer {
  appointmentDate: Date;
  dateTransfer: Date;
  destinationAccount: string;
  tax: number;
  totalValue: number;
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
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.generateMockData();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  // Geração de dados mockados
  private generateMockData(): void {
    const mockTransfers: Transfer[] = [];
    
    for (let i = 1; i <= 15; i++) {
      mockTransfers.push({
        appointmentDate: new Date(2024, 0, i),
        dateTransfer: new Date(2024, 0, i, 12, 0),
        destinationAccount: `${'0123456789' + i}`,
        tax: i * 1.5,
        totalValue: 1000 + (i * 100)
      });
    }

    this.dataSource.data = mockTransfers;
    this.totalItems = mockTransfers.length;
  }

  // Manipulador de mudança de página
  onPageChange(event: PageEvent): void {
    this.pageSize = event.pageSize;
    // Aqui você implementaria a lógica para carregar mais dados do servidor se necessário
  }

  close(): void {
    this.dialogRef.close();
  }
}