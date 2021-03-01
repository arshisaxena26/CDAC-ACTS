import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeneficiaryApplyForVaccinationComponent } from './beneficiary-apply-for-vaccination.component';

describe('BeneficiaryApplyForVaccinationComponent', () => {
  let component: BeneficiaryApplyForVaccinationComponent;
  let fixture: ComponentFixture<BeneficiaryApplyForVaccinationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BeneficiaryApplyForVaccinationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BeneficiaryApplyForVaccinationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
