import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DistrictOfficeApplicationsComponent } from './district-office-applications.component';

describe('DistrictOfficeApplicationsComponent', () => {
  let component: DistrictOfficeApplicationsComponent;
  let fixture: ComponentFixture<DistrictOfficeApplicationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DistrictOfficeApplicationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DistrictOfficeApplicationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
