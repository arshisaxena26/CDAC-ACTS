import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccinationCentreReportsComponent } from './vaccination-centre-reports.component';

describe('VaccinationCentreReportsComponent', () => {
  let component: VaccinationCentreReportsComponent;
  let fixture: ComponentFixture<VaccinationCentreReportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccinationCentreReportsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VaccinationCentreReportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
