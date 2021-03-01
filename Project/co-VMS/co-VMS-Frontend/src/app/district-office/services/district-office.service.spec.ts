import { TestBed } from '@angular/core/testing';

import { DistrictOfficeService } from './district-office.service';

describe('DistrictOfficeService', () => {
  let service: DistrictOfficeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DistrictOfficeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
