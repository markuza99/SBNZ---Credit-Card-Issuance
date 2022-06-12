import { TestBed } from '@angular/core/testing';

import { BasketOfGoodsService } from './basket-of-goods.service';

describe('BasketOfGoodsService', () => {
  let service: BasketOfGoodsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BasketOfGoodsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
