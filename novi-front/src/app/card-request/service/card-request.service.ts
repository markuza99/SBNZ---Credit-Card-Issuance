import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CardRequestService {

  constructor(private http: HttpClient) { }
  createCard(val): Observable<String> {
    return this.http.post('/api/bank/chain', val,{headers:{
      Authorization: 'Bearer ' + localStorage.getItem('token'),
    },responseType:'text'});
  }
}
