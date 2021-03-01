import { TestBed } from '@angular/core/testing';

import { VaccinationCentreService } from './vaccination-centre.service';

describe('VaccinationCentreService', () => {
  let service: VaccinationCentreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VaccinationCentreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
