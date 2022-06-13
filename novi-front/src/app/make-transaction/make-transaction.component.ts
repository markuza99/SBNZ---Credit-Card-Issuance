import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { CreditCard } from '../models/CreditCard';
import { Transaction } from '../models/Transaction';
import { MakeTransactionService } from './service/make-transaction.service';

@Component({
  selector: 'app-make-transaction',
  templateUrl: './make-transaction.component.html',
  styleUrls: ['./make-transaction.component.css'],
  providers: [MessageService]
})
export class MakeTransactionComponent implements OnInit {

  constructor(private messageService: MessageService,private makeTransactionService: MakeTransactionService) { }

  cards: CreditCard[]
  userCards: CreditCard[]
  selectedCard: CreditCard = null
  selectedUserCard: CreditCard = null
  amount: Number = 0;

  ngOnInit(): void {
    this.makeTransactionService.getCreditCards().subscribe(res => {
      this.cards = res;
      this.userCards = res.filter(card => card.cardOwner.split(" ")[0] == localStorage.getItem("username"));
    })
  }

  makeTransaction(): void {
    if(!this.selectedUserCard || !this.selectedCard || !this.amount || this.amount <= 0.0) {
      this.messageService.add({key: 'tc', severity:'error', summary: 'Empty fields', detail: 'Please dont leave empty fields!'});
      return;
    }
    if(this.selectedCard.cardNumber == this.selectedUserCard.cardNumber) {
      this.messageService.add({key: 'tc', severity:'error', summary: 'Same card', detail: 'Please dont use same card for payer and receiver!'});
      return;
    }
    var transaction: Transaction = {
      payerId: this.selectedUserCard.id,
      recipientId: this.selectedCard.id,
      totalAmount: this.amount
    }
    this.makeTransactionService.postTransaction(transaction).subscribe(res => {
      if(res.toString() == "Transaction Warning") {
        this.messageService.add({key: 'tc', severity:'warn', summary: res.toString(), detail: 'Your transaction has been successful, however your card is suspicious!'});
      }
      if(res.toString() == "Transaction Successful") {
        this.messageService.add({key: 'tc', severity:'success', summary: res.toString(), detail: 'Your transaction has been successful!'});
      }
      if(res.toString() == "Transaction Blocked") {
        this.messageService.add({key: 'tc', severity:'error', summary: res.toString(), detail: 'Your transaction has been denied, because your card is blocked!'});
      }
    })
    console.log(transaction)
  }

}
