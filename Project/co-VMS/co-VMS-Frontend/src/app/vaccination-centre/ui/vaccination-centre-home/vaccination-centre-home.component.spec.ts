import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccinationCentreHomeComponent } from './vaccination-centre-home.component';

describe('VaccinationCentreHomeComponent', () => {
  let component: VaccinationCentreHomeComponent;
  let fixture: ComponentFixture<VaccinationCentreHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccinationCentreHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VaccinationCentreHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
