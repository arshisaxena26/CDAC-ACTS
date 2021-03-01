import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigationHomeComponent } from './navigation-home.component';

describe('NavigationHomeComponent', () => {
  let component: NavigationHomeComponent;
  let fixture: ComponentFixture<NavigationHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavigationHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavigationHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
