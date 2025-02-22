import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatDialog } from '@angular/material/dialog';
import { MatMenuModule } from '@angular/material/menu';
import { ScheduleTransferComponent } from './tranfers-dialog/tranfers-dialog.component'; 
import { TransferModalComponent } from './transfer-modal/transfer-modal.component';
import { CommonModule } from '@angular/common';
import { StorageService } from './storage.service';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login-page/login-page.component';
import { ApiService } from './service/api.service';
import { ConfirmationPopComponent } from './confirmation-pop/confirmation-pop.component';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [MatCardModule, MatMenuModule, CommonModule], 
})
export class AppComponent {
  isLoggedIn: boolean = false;
  balance: number = 0; 
  name: string = '';
  accountNumber: string = '';
  
  constructor(private dialog: MatDialog, 
    private storageService: StorageService,       
    private apiService: ApiService,
  ) {}
  
  register() {
    const dialogRef = this.dialog.open(RegisterComponent, {
      width: '400px', 
      data: {} 
    })
    dialogRef.afterClosed().subscribe(result => {
      this.validaToken();
    });
  }
  login() {
    const dialogRef = this.dialog.open(LoginComponent, {
      width: '400px', 
      data: {} 
    });
    dialogRef.afterClosed().subscribe(result => {
      if (localStorage.getItem('token')!='') {
        this.validaToken();
      }
    });
  }

  openDialog() {
    const dialogRef = this.dialog.open(ScheduleTransferComponent, {
      width: '400px', 
      data: {} 
    });
    dialogRef.afterClosed().subscribe(result => {
      this.validaToken();
    });
  }

  listTranfers() {

    const dialogRef = this.dialog.open(TransferModalComponent, {
      width: '800px',
      maxWidth: '90vw',
      data: {originAccount: this.accountNumber} 
    });
    dialogRef.afterClosed().subscribe(result => {
        this.validaToken();
      
    });
  }

  logout() {
    this.apiService.clearLocalStorage();
    this.isLoggedIn = false;
  }
  popupConfirmation(mensagem: string, response: string){ {
    const dialogRef = this.dialog.open(ConfirmationPopComponent, {
      width: '400px', 
      data: {
        mensagem: mensagem,
        tipo: response
      } 
    });
  }
} 
  validaToken(){
    try {
      const token = localStorage.getItem('token');
      const balance = localStorage.getItem('balance');
      const name = localStorage.getItem('name');
      const accountNumber = localStorage.getItem('originAccount');
      if (!token || !balance || !name) {
        this.popupConfirmation('Token inválido', 'erro');
        this.isLoggedIn = false;
        return false;
      }
      this.accountNumber = accountNumber || '';
      this.isLoggedIn = true;
      this.balance = parseFloat(balance) || 0;
      this.name = name || '';

      return true;
    } catch (error) {
      console.error('Erro ao validar token:', error);
      return false;
    }
  }
}