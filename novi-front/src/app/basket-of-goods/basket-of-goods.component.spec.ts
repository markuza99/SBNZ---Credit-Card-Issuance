import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BasketOfGoodsComponent } from './basket-of-goods.component';

describe('BasketOfGoodsComponent', () => {
  let component: BasketOfGoodsComponent;
  let fixture: ComponentFixture<BasketOfGoodsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BasketOfGoodsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BasketOfGoodsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
