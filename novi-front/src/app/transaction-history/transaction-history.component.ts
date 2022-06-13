import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TransactionView } from '../models/Transaction';
import { TransactionHistoryService } from './service/transaction-history.service';

@Component({
  selector: 'app-transaction-history',
  templateUrl: './transaction-history.component.html',
  styleUrls: ['./transaction-history.component.css']
})
export class TransactionHistoryComponent implements OnInit {

  constructor(private route: ActivatedRoute, private transactionHistoryService: TransactionHistoryService) { }
  transactions: TransactionView[]
  ngOnInit(): void {
    this.route.params.subscribe(res => {
      this.transactionHistoryService.getTransactions(res["id"]).subscribe(data => {
        this.transactions = data
      })
    })
  }

}
