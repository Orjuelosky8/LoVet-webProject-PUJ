import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckPetsComponent } from './check-pets.component';

describe('CheckPetsComponent', () => {
  let component: CheckPetsComponent;
  let fixture: ComponentFixture<CheckPetsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CheckPetsComponent]
    });
    fixture = TestBed.createComponent(CheckPetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
