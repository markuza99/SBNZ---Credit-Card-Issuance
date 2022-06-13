import { Component, OnInit } from '@angular/core';
import { CardRequestService } from './service/card-request.service';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-card-request',
  templateUrl: './card-request.component.html',
  styleUrls: ['./card-request.component.css'],
  providers: [MessageService]
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
  constructor(private cardRequestService: CardRequestService, private messageService: MessageService) { }
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
    if((cardInfo.limit <= 0) || (cardInfo.installments <= 0) || !(cardInfo.brand)) {
      this.messageService.add({key: 'tc', severity:'error', summary: 'Empyty fields', detail: 'Please dont leave empty fields!'});
      return;
    }
    this.cardRequestService.createCard(cardInfo).subscribe(data => {
      console.log(data);
      if(data.startsWith("Request denied:")) {
        this.messageService.add({key: 'tc', severity:'error', summary: 'Request denied', detail: data.toString()});
      }
      else {
        this.messageService.add({key: 'tc', severity:'success', summary: 'Request accepted', detail: data.toString()});
        this.limit = 0;
        this.selectedCard = {};
        this.installments = 0;
      }
      
    })
    
  }

  ngOnInit(): void {
  }

}
