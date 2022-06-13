import { TestBed } from '@angular/core/testing';

import { MakeTransactionService } from './make-transaction.service';

describe('MakeTransactionService', () => {
  let service: MakeTransactionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MakeTransactionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
