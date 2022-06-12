import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from './login/service/login-service.service';
import { LogoutService } from './logout/service/logout.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'novi-front';
  role: string | null = '';
  /**
   *
   */
  constructor(private logoutService: LogoutService,private loginService: LoginServiceService) {
    this.loginService.getUserRole.subscribe(() => {
      this.setRole(localStorage.getItem('role'));
    });
    this.logoutService.logout.subscribe(() => {
      this.setRole('');
    });
  }

  setRole = (role: string | null) => {
    this.role = role;
  };

  ngOnInit(): void {
    this.setRole(localStorage.getItem('role'));
  }
}
