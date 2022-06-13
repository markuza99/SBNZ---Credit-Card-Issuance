import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TransactionView } from 'src/app/models/Transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionHistoryService {

  constructor(private http: HttpClient) { }

  getTransactions(id): Observable<TransactionView[]> {
    return this.http.get<TransactionView[]>('/api/bank/transactions/'+id, {headers:{
      Authorization: 'Bearer ' + localStorage.getItem('token'),
    }});
  }
}
