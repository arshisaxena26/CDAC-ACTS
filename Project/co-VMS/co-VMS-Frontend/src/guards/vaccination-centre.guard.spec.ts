import { TestBed } from '@angular/core/testing';

import { VaccinationCentreGuard } from './vaccination-centre.guard';

describe('VaccinationCentreGuard', () => {
  let guard: VaccinationCentreGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(VaccinationCentreGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
