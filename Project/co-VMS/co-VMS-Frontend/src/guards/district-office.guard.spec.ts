import { TestBed } from '@angular/core/testing';

import { DistrictOfficeGuard } from './district-office.guard';

describe('DistrictOfficeGuard', () => {
  let guard: DistrictOfficeGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(DistrictOfficeGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
