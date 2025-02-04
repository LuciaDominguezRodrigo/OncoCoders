import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcessedPacientsComponent } from './processed-pacients.component';

describe('ProcessedPacientsComponent', () => {
  let component: ProcessedPacientsComponent;
  let fixture: ComponentFixture<ProcessedPacientsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProcessedPacientsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProcessedPacientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
