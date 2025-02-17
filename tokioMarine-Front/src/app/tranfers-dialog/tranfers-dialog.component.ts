import { Component, Inject } from '@angular/core';
import { MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxCurrencyDirective } from "ngx-currency";
import { CommonModule } from '@angular/common';
import { ApiService } from '../service/api.service';


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
  ],
  providers:[
    ApiService,
  ]
})
export class ScheduleTransferComponent {
  transfer = {
    conta_origem: '',
    conta_destino: '',
    valor: 0,
    data_Agendamento: ''
  };

  constructor(
    public dialogRef: MatDialogRef<ScheduleTransferComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private apiService: ApiService 
  ) {}

  onCancel() {
    this.dialogRef.close();
  }

  onSave() {
    this.apiService.salvarTransferencia(this.transfer).subscribe(
      response => {
        console.log('Transferência salva com sucesso:', response);
        //this.dialogRef.close(); 
      },
      error => {
        console.error('Erro ao salvar transferência:', error);
      }
    );
  }

  blur() {
    console.log('Input blurred');
  }
}