import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingPacientsComponent } from './pending-pacients.component';

describe('PendingPacientsComponent', () => {
  let component: PendingPacientsComponent;
  let fixture: ComponentFixture<PendingPacientsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PendingPacientsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PendingPacientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
