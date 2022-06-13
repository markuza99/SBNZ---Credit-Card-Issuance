import { Component, OnInit } from '@angular/core';
import { UserCredentials } from '../models/UserCredentials';
import { LoginServiceService } from './service/login-service.service';
import jwt_decode from 'jwt-decode';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers:[MessageService]

})
export class LoginComponent implements OnInit {


  constructor(private messageService: MessageService,private loginService: LoginServiceService,private router: Router) { }
  creds: UserCredentials = {
    username: "",
    password: ""
  }
  ngOnInit(): void {
    this.messageService.add({key: 'tc', severity:'success', summary: 'Article successfully updated', detail: 'Updated article'});

  }

  login(): void {
    if(!this.creds.username.trim() || !this.creds.password.trim()) {
      this.messageService.add({key: 'tc', severity:'error', summary: 'Invalid data', detail: 'Please fill in the input fields!'});
      return;
    }

    this.loginService.getToken(this.creds).subscribe(res => {
      console.log(res)
      var token = jwt_decode(res["token"])
      localStorage.setItem("username", token["sub"])
      localStorage.setItem("roles", token["roles"])
      localStorage.setItem("token", res["token"])
      this.loginService.emitLogin();
      this.router.navigateByUrl('/basket');

    }, err => {
      this.messageService.add({key: 'tc', severity:'error', summary: 'Invalid data', detail: 'User with entered credentials does not exist!'});
    })

  }

}
