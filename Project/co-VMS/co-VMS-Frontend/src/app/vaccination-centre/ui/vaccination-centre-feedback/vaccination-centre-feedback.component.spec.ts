import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccinationCentreFeedbackComponent } from './vaccination-centre-feedback.component';

describe('VaccinationCentreFeedbackComponent', () => {
  let component: VaccinationCentreFeedbackComponent;
  let fixture: ComponentFixture<VaccinationCentreFeedbackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccinationCentreFeedbackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VaccinationCentreFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
