import { TestBed } from '@angular/core/testing';

import { ManufactureService } from './manufacture.service';

describe('ManufactureserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ManufactureService = TestBed.get(ManufactureService);
    expect(service).toBeTruthy();
  });
});
