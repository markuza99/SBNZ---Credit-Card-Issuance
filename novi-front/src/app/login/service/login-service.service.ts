import {EventEmitter, Injectable, Output } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { UserCredentials } from 'src/app/models/UserCredentials';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  @Output() getUserRole: EventEmitter<any> = new EventEmitter();

  constructor(private http: HttpClient ) { }



  getToken(userCred: UserCredentials) {
    return this.http.post('/api/bank/authenticate', userCred);
  }

  emitLogin = () => {
    this.getUserRole.emit();
  };
}
