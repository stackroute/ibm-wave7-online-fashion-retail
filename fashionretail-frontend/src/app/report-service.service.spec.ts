import { TestBed } from '@angular/core/testing';

import { ReportServiceService } from './report-service.service';

describe('ReportServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReportServiceService = TestBed.get(ReportServiceService);
    expect(service).toBeTruthy();
  });
});
