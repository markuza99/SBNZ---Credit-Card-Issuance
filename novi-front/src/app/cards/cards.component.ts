import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CreditCard } from '../models/CreditCard';
import { CardsService } from './service/cards.service';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit {

  constructor(private route: ActivatedRoute, private cardsService: CardsService, private router: Router) { }
  cards: CreditCard[]
  proba(id): void {
    this.router.navigateByUrl("/transaction-history/"+id)
  }
  ngOnInit(): void {
    this.cardsService.getCreditCards(localStorage.getItem("username")).subscribe(data => {
      this.cards = data
      console.log(data)
    })
    // this.route.params.subscribe(res => {
    //   console.log(res["id"]);
    //   this.cardsService.getCreditCards(res["id"]).subscribe(data => {
    //     this.cards = data
    //     console.log(data)
    //   })
    // })
  }

}
