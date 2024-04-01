import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagePetsComponent } from './manage-pets.component';

describe('ManagePetsComponent', () => {
  let component: ManagePetsComponent;
  let fixture: ComponentFixture<ManagePetsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManagePetsComponent]
    });
    fixture = TestBed.createComponent(ManagePetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
