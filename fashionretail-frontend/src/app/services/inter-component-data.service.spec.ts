import { TestBed } from '@angular/core/testing';

import { InterComponentDataService } from './inter-component-data.service';

describe('InterComponentDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InterComponentDataService = TestBed.get(InterComponentDataService);
    expect(service).toBeTruthy();
  });
});
