import { Component, OnInit } from '@angular/core';
import { BasketOfGoods } from '../models/Template';
import { BasketOfGoodsService } from './service/basket-of-goods.service';
import { MessageService } from 'primeng/api';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';

@Component({
  selector: 'app-basket-of-goods',
  templateUrl: './basket-of-goods.component.html',
  styleUrls: ['./basket-of-goods.component.css'],
  providers:[MessageService]

})
export class BasketOfGoodsComponent implements OnInit {

  constructor(private messageService:MessageService,private basketOfGoodsService: BasketOfGoodsService) { }
  val: String
  ngOnInit(): void {
    this.getBasketOfGoods();
  }

  getBasketOfGoods(): void {
    this.basketOfGoodsService.getBasketOfGoods().subscribe(res =>{
      this.val = res;
    })
  }

  basket: BasketOfGoods = {
    basketOfGoods:0
  }

  setBasketOfGoods() {
    if(this.basket.basketOfGoods <= 0) {
      this.messageService.add({key: 'tc', severity:'error', summary: 'Invalid data', detail: 'Basket of goods cannot be less than 0 EUR!'});
      return;
    }
    this.basketOfGoodsService.postBasketOfGoods(this.basket).subscribe(res => {
      this.getBasketOfGoods();
      this.messageService.add({key: 'tc', severity:'success', summary: 'Basket of goods updated', detail: 'Basket of goods has been successfully updated!'});

    })
  }

}
