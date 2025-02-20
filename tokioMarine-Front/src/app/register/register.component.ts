import { Component, Inject } from '@angular/core';
import { MatDialogModule, MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ApiService } from '../service/api.service';
import { MatTableModule } from '@angular/material/table';
import { ConfirmationPopComponent } from '../confirmation-pop/confirmation-pop.component';
import { catchError, of, switchMap } from 'rxjs';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
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
export class RegisterComponent {
  erroUsuario: boolean = false;
  erro_msg: string = '';
  register = {
    name: '',
    cpf: '',
    password: ''
  };

    constructor(
      public dialogRef: MatDialogRef<RegisterComponent>,
      @Inject(MAT_DIALOG_DATA) public data: any,
      private apiService: ApiService,
      private dialog: MatDialog,
    ) {}

  onSave() {
    this.apiService.register(this.register).pipe(
      switchMap(() => this.apiService.login(this.register)), 
      catchError(error => this.handleError(error)) 
    ).subscribe(response => {
      this.apiService.clearLocalStorage();
      this.apiService.localStorageset(response);
      this.popupConfirmation('Cadastro Realizado', 'sucesso');
    });
  }  
  private handleError(error: any) {
    this.erroUsuario = true;
    this.erro_msg = error.error?.password || 'Ocorreu um erro';
    return of(null);
  }
  popupConfirmation(mensagem: string, response: string){ {
    this.dialogRef.close();
    const dialogRef = this.dialog.open(ConfirmationPopComponent, {
      width: '400px', 
      data: {
        mensagem: mensagem,
        tipo: response
      } 
    });
  }}  
  onCancel() {
    this.dialogRef.close();
  }
}
