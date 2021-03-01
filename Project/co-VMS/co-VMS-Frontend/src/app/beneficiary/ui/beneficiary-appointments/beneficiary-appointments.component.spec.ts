import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeneficiaryAppointmentsComponent } from './beneficiary-appointments.component';

describe('BeneficiaryAppointmentsComponent', () => {
  let component: BeneficiaryAppointmentsComponent;
  let fixture: ComponentFixture<BeneficiaryAppointmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BeneficiaryAppointmentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BeneficiaryAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
