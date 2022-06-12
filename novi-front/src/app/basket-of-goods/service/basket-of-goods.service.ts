import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BasketOfGoods } from 'src/app/models/Template';

@Injectable({
  providedIn: 'root'
})
export class BasketOfGoodsService {

  postBasketOfGoods(val: BasketOfGoods): Observable<String> {
    return this.http.post('/api/bank/template', val,{headers:{
      Authorization: 'Bearer ' + localStorage.getItem('token'),
    },responseType:'text'});
  }

  getBasketOfGoods(): Observable<String> {
    return this.http.get('/api/bank/basket', {headers:{
      Authorization: 'Bearer ' + localStorage.getItem('token'),
    },responseType:'text'});
  }
  constructor(private http: HttpClient) {

   }
}
