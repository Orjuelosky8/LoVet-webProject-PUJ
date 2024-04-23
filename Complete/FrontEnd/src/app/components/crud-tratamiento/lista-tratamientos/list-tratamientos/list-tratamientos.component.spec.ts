import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListTratamientosComponent } from './list-tratamientos.component';

describe('ListTratamientosComponent', () => {
  let component: ListTratamientosComponent;
  let fixture: ComponentFixture<ListTratamientosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListTratamientosComponent]
    });
    fixture = TestBed.createComponent(ListTratamientosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
