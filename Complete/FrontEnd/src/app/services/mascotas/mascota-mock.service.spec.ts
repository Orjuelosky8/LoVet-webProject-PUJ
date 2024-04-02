import { TestBed } from '@angular/core/testing';

import { MascotaMockService } from './mascota-mock.service';

describe('MascotaMockService', () => {
  let service: MascotaMockService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MascotaMockService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
