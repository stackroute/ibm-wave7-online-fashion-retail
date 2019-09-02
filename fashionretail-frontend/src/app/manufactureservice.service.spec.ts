import { TestBed } from '@angular/core/testing';

import { ManufactureserviceService } from './manufactureservice.service';

describe('ManufactureserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ManufactureserviceService = TestBed.get(ManufactureserviceService);
    expect(service).toBeTruthy();
  });
});
