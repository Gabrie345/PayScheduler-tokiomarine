import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmationPopComponent } from './confirmation-pop.component';
import { BrowserModule } from '@angular/platform-browser';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';

describe('ConfirmationPopComponent', () => {
  let component: ConfirmationPopComponent;
  let fixture: ComponentFixture<ConfirmationPopComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConfirmationPopComponent,
        BrowserModule,
        MatIconModule,
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConfirmationPopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
