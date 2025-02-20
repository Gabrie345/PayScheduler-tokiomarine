import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA, MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ApiService } from '../service/api.service';
import { MatTableModule } from '@angular/material/table';
import { ConfirmationPopComponent } from '../confirmation-pop/confirmation-pop.component';
import { catchError, of } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
  imports: [
    CommonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    MatTableModule
  ],
})
export class LoginComponent {
  erroUsuario: boolean = false;
  erro_msg: string = '';
  login = {
    cpf: '',
    password: ''
  };

  constructor(
    public dialogRef: MatDialogRef<LoginComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private apiService: ApiService,
    private dialog: MatDialog
  ) {}

  onLogin() {
    this.apiService.login(this.login).pipe(
      catchError(error => this.handleError(error))
    ).subscribe(response => {
      if (response) {
        this.apiService.clearLocalStorage();
        this.apiService.localStorageset(response);
        this.popupConfirmation('Login realizado com sucesso!', 'sucesso');
      }
    });
  }

  private handleError(error: any) {
    this.erroUsuario = true;
    this.erro_msg = error.error?.message || 'CPF ou senha inválidos';
    return of(null);
  }

  popupConfirmation(mensagem: string, response: string) {
    this.dialogRef.close();
    this.dialog.open(ConfirmationPopComponent, {
      width: '400px',
      data: {
        mensagem: mensagem,
        tipo: response
      }
    });
  }

  onCancel() {
    this.dialogRef.close();
  }
}
