import { Component, OnInit } from '@angular/core';
import { CardRequestService } from './service/card-request.service';

@Component({
  selector: 'app-card-request',
  templateUrl: './card-request.component.html',
  styleUrls: ['./card-request.component.css']
})
export class CardRequestComponent implements OnInit {


  cards = [
    {
    name:"VISA",
    id:"VISA"
    },
    {
      name:"MASTER",
      id:"MASTER"
    },
    {
      name:"DINA",
      id:"DINA"
    },
  ]
  selectedCard ={}
  limit: number = 0
  installments:number = 0
  constructor(private cardRequestService: CardRequestService) { }
  postCard(): void {
    var cardInfo = {
      userId:localStorage.getItem("username"),
      limit:this.limit,
      installments:this.installments,
      brand:this.selectedCard["id"],
      cardStatus:"START",
      typeDeposit:"NA",
      ageDeposit:"NA",
      clientDeposit:"NA"
    }
    this.cardRequestService.createCard(cardInfo).subscribe(data => {
      console.log(data);
    })
    this.limit = 0;
    this.selectedCard = {};
    this.installments = 0;
  }

  ngOnInit(): void {
  }

}
