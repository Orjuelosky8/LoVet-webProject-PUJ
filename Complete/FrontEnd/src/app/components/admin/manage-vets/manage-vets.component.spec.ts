import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageVetsComponent } from './manage-vets.component';

describe('ManageVetsComponent', () => {
  let component: ManageVetsComponent;
  let fixture: ComponentFixture<ManageVetsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManageVetsComponent]
    });
    fixture = TestBed.createComponent(ManageVetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
