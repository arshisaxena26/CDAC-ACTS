import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccinationCentreDashboardComponent } from './vaccination-centre-dashboard.component';

describe('VaccinationCentreDashboardComponent', () => {
  let component: VaccinationCentreDashboardComponent;
  let fixture: ComponentFixture<VaccinationCentreDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccinationCentreDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VaccinationCentreDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
