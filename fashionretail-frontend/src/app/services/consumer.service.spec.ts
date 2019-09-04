import { TestBed } from '@angular/core/testing';

import { ConsumerService } from './consumer.service';

describe('ConsumerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ConsumerService = TestBed.get(ConsumerService);
    expect(service).toBeTruthy();
  });
});
