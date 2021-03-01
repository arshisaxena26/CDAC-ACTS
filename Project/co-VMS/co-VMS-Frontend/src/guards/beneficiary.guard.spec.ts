import { TestBed } from '@angular/core/testing';

import { BeneficiaryGuard } from './beneficiary.guard';

describe('BeneficiaryGuard', () => {
  let guard: BeneficiaryGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(BeneficiaryGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
