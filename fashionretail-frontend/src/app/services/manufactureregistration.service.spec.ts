import { TestBed } from '@angular/core/testing';

import { ManufactureregistrationService } from './manufactureregistration.service';

describe('ManufactureregistrationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ManufactureregistrationService = TestBed.get(ManufactureregistrationService);
    expect(service).toBeTruthy();
  });
});
