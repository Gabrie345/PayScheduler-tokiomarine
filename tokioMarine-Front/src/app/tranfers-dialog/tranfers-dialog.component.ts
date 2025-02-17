import { Component, Inject } from '@angular/core';
import { MatDialogModule, MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxCurrencyDirective } from "ngx-currency";
import { CommonModule } from '@angular/common';
import { ApiService } from '../service/api.service';
import { ConfirmationPopComponent } from '../confirmation-pop/confirmation-pop.component';
import { MatTableModule } from '@angular/material/table';


@Component({
  selector: 'app-tranfers-dialog',
  templateUrl: './tranfers-dialog.component.html',
  styleUrls: ['./tranfers-dialog.component.css'],
  standalone: true,
  imports: [
    CommonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    NgxCurrencyDirective,
    MatTableModule
  ],
  providers:[
    ApiService,
  ]
})
export class ScheduleTransferComponent {
  transfer = {
    conta_origem: '',
    conta_destino: '',
    valor: '',
    data_Agendamento: ''
  };
  mensagem: string | null = null;
  response: string | null = null;

  constructor(
    public dialogRef: MatDialogRef<ScheduleTransferComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private apiService: ApiService,
    private dialog: MatDialog
  ) {}

  onCancel() {
    this.dialogRef.close();
  }

  onSave() {
    this.transfer.data_Agendamento = this.dateFormart(this.transfer.data_Agendamento);
    this.apiService.saveTransfer(this.transfer).subscribe(
      response => {
        this.popupConfirmation('Transferência salva com sucesso', 'sucesso');
      },
      error => {
        this.popupConfirmation(error?.error?.error, 'erro');
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
  dateFormart(date: string){
    const partes = date.split('-');
    return `${partes[2]}/${partes[1]}/${partes[0]}`;
  }
  blur() {
    console.log('Input blurred');
  }
}