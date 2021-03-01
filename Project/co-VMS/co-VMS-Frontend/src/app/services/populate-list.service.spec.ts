import { TestBed } from '@angular/core/testing';

import { PopulateListService } from './populate-list.service';

describe('PopulateListService', () => {
  let service: PopulateListService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PopulateListService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
