import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListVeterinariosComponent } from './list-veterinarios.component';

describe('ListVeterinariosComponent', () => {
  let component: ListVeterinariosComponent;
  let fixture: ComponentFixture<ListVeterinariosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListVeterinariosComponent]
    });
    fixture = TestBed.createComponent(ListVeterinariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
