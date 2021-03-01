import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VaccinationCentreInventoryComponent } from './vaccination-centre-inventory.component';

describe('VaccinationCentreInventoryComponent', () => {
  let component: VaccinationCentreInventoryComponent;
  let fixture: ComponentFixture<VaccinationCentreInventoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VaccinationCentreInventoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VaccinationCentreInventoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
