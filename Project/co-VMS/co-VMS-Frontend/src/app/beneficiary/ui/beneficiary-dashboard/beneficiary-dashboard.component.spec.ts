import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeneficiaryDashboardComponent } from './beneficiary-dashboard.component';

describe('BeneficiaryDashboardComponent', () => {
  let component: BeneficiaryDashboardComponent;
  let fixture: ComponentFixture<BeneficiaryDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BeneficiaryDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BeneficiaryDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
