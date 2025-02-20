import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatDialog } from '@angular/material/dialog';
import { MatMenuModule } from '@angular/material/menu';
import { ScheduleTransferComponent } from './tranfers-dialog/tranfers-dialog.component'; 
import { TransferModalComponent } from './transfer-modal/transfer-modal.component';
import { CommonModule } from '@angular/common';
import { StorageService } from './storage.service';
import { RegisterComponent } from './register/register.component';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [MatCardModule, MatMenuModule, CommonModule], 
})
export class AppComponent {
  isLoggedIn: boolean = false;
  saldo: number = 0; 

  constructor(private dialog: MatDialog, private storageService: StorageService) {}

  ngOnInit(): void {
  }

  register() {
    const dialogRef = this.dialog.open(RegisterComponent, {
      width: '400px', 
      data: {} 
    })
  }
    login() {
    throw new Error('Method not implemented.');
  }


  openDialog() {
    const dialogRef = this.dialog.open(ScheduleTransferComponent, {
      width: '400px', 
      data: {} 
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('O modal foi fechado!');
    });
  }

  listTranfers() {
    const dialogRef = this.dialog.open(TransferModalComponent, {
      width: '800px',
      maxWidth: '90vw',
      data: {account:"0123456789"} 
    });
  }

  logout() {
    console.log('Logout realizado');
  }
}