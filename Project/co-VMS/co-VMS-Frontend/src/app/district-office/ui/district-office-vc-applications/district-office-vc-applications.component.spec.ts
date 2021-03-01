import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DistrictOfficeVcApplicationsComponent } from './district-office-vc-applications.component';

describe('DistrictOfficeVcApplicationsComponent', () => {
  let component: DistrictOfficeVcApplicationsComponent;
  let fixture: ComponentFixture<DistrictOfficeVcApplicationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DistrictOfficeVcApplicationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DistrictOfficeVcApplicationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
