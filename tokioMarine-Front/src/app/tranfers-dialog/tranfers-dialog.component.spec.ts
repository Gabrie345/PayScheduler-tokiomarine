import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TranfersDialogComponent } from './tranfers-dialog.component';

describe('TranfersDialogComponent', () => {
  let component: TranfersDialogComponent;
  let fixture: ComponentFixture<TranfersDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TranfersDialogComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TranfersDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
