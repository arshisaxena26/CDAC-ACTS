import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DistrictOfficeDashboardComponent } from './district-office-dashboard.component';

describe('DistrictOfficeDashboardComponent', () => {
  let component: DistrictOfficeDashboardComponent;
  let fixture: ComponentFixture<DistrictOfficeDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DistrictOfficeDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DistrictOfficeDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
