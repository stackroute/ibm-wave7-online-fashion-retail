import { TestBed } from '@angular/core/testing';

import { SupplierServiceService } from './supplier-service.service';

describe('SupplierServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SupplierServiceService = TestBed.get(SupplierServiceService);
    expect(service).toBeTruthy();
  });
});
