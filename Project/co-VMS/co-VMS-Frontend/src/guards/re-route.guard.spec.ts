import { TestBed } from '@angular/core/testing';

import { ReRouteGuard } from './re-route.guard';

describe('ReRouteGuard', () => {
  let guard: ReRouteGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ReRouteGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
