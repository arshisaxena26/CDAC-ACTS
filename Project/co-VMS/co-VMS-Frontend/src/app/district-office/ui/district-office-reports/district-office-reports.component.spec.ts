import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DistrictOfficeReportsComponent } from './district-office-reports.component';

describe('DistrictOfficeReportsComponent', () => {
  let component: DistrictOfficeReportsComponent;
  let fixture: ComponentFixture<DistrictOfficeReportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DistrictOfficeReportsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DistrictOfficeReportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
