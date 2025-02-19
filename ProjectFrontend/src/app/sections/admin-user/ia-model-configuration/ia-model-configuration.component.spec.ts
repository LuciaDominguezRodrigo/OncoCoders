import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IAModelConfigurationComponent } from './ia-model-configuration.component';

describe('IAModelConfigurationComponent', () => {
  let component: IAModelConfigurationComponent;
  let fixture: ComponentFixture<IAModelConfigurationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IAModelConfigurationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IAModelConfigurationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
