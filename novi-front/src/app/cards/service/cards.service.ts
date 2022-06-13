import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CreditCard } from 'src/app/models/CreditCard';

@Injectable({
  providedIn: 'root'
})
export class CardsService {


  constructor(private http: HttpClient) { }

  getCreditCards(user): Observable<CreditCard[]> {
    return this.http.get<CreditCard[]>('/api/bank/cards/'+user, {headers:{
      Authorization: 'Bearer ' + localStorage.getItem('token'),
    }});
  }

  proba(e): void {
    console.log(e);
  }
}
