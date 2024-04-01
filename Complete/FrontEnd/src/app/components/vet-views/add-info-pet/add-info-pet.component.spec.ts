import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddInfoPetComponent } from './add-info-pet.component';

describe('AddInfoPetComponent', () => {
  let component: AddInfoPetComponent;
  let fixture: ComponentFixture<AddInfoPetComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddInfoPetComponent]
    });
    fixture = TestBed.createComponent(AddInfoPetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
