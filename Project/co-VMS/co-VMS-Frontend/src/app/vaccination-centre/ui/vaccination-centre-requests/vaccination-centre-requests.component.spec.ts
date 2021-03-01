import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccinationCentreRequestsComponent } from './vaccination-centre-requests.component';

describe('VaccinationCentreRequestsComponent', () => {
  let component: VaccinationCentreRequestsComponent;
  let fixture: ComponentFixture<VaccinationCentreRequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccinationCentreRequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VaccinationCentreRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
