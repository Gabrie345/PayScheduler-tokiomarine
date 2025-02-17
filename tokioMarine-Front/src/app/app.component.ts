import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatDialog } from '@angular/material/dialog'; 
import { ScheduleTransferComponent } from './tranfers-dialog/tranfers-dialog.component'; 
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
    console.log('Listar transferências');
  }
}