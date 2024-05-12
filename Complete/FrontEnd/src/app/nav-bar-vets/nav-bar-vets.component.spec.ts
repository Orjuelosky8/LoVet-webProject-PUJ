import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavBarVetsComponent } from './nav-bar-vets.component';

describe('NavBarVetsComponent', () => {
  let component: NavBarVetsComponent;
  let fixture: ComponentFixture<NavBarVetsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavBarVetsComponent]
    });
    fixture = TestBed.createComponent(NavBarVetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
