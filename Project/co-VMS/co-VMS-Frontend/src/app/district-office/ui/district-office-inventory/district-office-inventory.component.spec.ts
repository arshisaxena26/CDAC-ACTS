import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DistrictOfficeInventoryComponent } from './district-office-inventory.component';

describe('DistrictOfficeInventoryComponent', () => {
  let component: DistrictOfficeInventoryComponent;
  let fixture: ComponentFixture<DistrictOfficeInventoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DistrictOfficeInventoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DistrictOfficeInventoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
