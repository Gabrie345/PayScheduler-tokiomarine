import { Component, Inject } from '@angular/core';
import { MatDialogModule, MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { TransferModalComponent } from '../transfer-modal/transfer-modal.component';


@Component({
  selector: 'app-confirmation-pop',
  templateUrl: './confirmation-pop.component.html',
  styleUrls: ['./confirmation-pop.component.css'],
  standalone: true,
  imports: [
    CommonModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    MatIconModule 
  ],
})
export class ConfirmationPopComponent {

onCancel() {
  this.dialogRef.close();
}
  constructor(
    public dialogRef: MatDialogRef<ConfirmationPopComponent>,
    private dialog: MatDialog,
    @Inject(MAT_DIALOG_DATA) public data: { mensagem: string, tipo: 'sucesso' | 'erro' }
  ) {}

}
