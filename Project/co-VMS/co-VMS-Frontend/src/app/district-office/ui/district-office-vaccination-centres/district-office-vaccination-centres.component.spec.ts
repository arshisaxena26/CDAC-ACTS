import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DistrictOfficeVaccinationCentresComponent } from './district-office-vaccination-centres.component';

describe('DistrictOfficeVaccinationCentresComponent', () => {
  let component: DistrictOfficeVaccinationCentresComponent;
  let fixture: ComponentFixture<DistrictOfficeVaccinationCentresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DistrictOfficeVaccinationCentresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DistrictOfficeVaccinationCentresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
