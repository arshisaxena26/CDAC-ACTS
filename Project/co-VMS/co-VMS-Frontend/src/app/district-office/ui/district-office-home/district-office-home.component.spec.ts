import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DistrictOfficeHomeComponent } from './district-office-home.component';

describe('DistrictOfficeHomeComponent', () => {
  let component: DistrictOfficeHomeComponent;
  let fixture: ComponentFixture<DistrictOfficeHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DistrictOfficeHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DistrictOfficeHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
