import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CreditCard } from 'src/app/models/CreditCard';
import { Transaction } from 'src/app/models/Transaction';

@Injectable({
  providedIn: 'root'
})
export class MakeTransactionService {

  constructor(private http: HttpClient) { }
  
  getCreditCards(): Observable<CreditCard[]> {
    return this.http.get<CreditCard[]>('/api/bank/cards', {headers:{
      Authorization: 'Bearer ' + localStorage.getItem('token'),
    }});
  }

  postTransaction(val: Transaction): Observable<String> {
    return this.http.post('/api/bank/trans', val,{headers:{
      Authorization: 'Bearer ' + localStorage.getItem('token'),
    },responseType:'text'});
  }
}
