import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatDialog } from '@angular/material/dialog'; 
import { ScheduleTransferComponent } from './tranfers-dialog/tranfers-dialog.component'; 
import { TransferModalComponent } from './transfer-modal/transfer-modal.component';
@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [MatCardModule], 
})
export class AppComponent {
  title = 'meu-projeto';

  constructor(private dialog: MatDialog) {} 

  openDialog() {
    const dialogRef = this.dialog.open(ScheduleTransferComponent, {
      width: '400px', 
      data: {} 
    });

  }

  listTranfers() {
    const dialogRef = this.dialog.open(TransferModalComponent, {
      width: '800px',
      maxWidth: '90vw',
      data: {} 
    });
  }
}