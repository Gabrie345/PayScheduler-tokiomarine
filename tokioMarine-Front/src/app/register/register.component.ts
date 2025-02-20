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
    this.apiService.register(this.register).subscribe(
      response => {
        this.popupConfirmation('Cadastro Realizado', 'sucesso');
      },
      error => {
        this.erroUsuario = true;
      }
    );
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
