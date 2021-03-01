import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeneficiaryHomeComponent } from './beneficiary-home.component';

describe('BeneficiaryHomeComponent', () => {
  let component: BeneficiaryHomeComponent;
  let fixture: ComponentFixture<BeneficiaryHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BeneficiaryHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BeneficiaryHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
