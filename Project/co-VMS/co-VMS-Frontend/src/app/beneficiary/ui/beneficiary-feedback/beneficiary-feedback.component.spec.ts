import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeneficiaryFeedbackComponent } from './beneficiary-feedback.component';

describe('BeneficiaryFeedbackComponent', () => {
  let component: BeneficiaryFeedbackComponent;
  let fixture: ComponentFixture<BeneficiaryFeedbackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BeneficiaryFeedbackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BeneficiaryFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
