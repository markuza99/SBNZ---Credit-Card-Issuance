import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LogoutService } from './service/logout.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css'],
})
export class LogoutComponent implements OnInit {
  constructor(private router: Router, private logoutService: LogoutService) {}

  
  ngOnInit(): void {
    localStorage.clear();
    this.logoutService.logoutFunction();
    this.router.navigateByUrl('/login');
  }
}