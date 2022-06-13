import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { LoginServiceService } from '../login/service/login-service.service';
import { LogoutService } from '../logout/service/logout.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  role: string
  constructor(private logoutService: LogoutService,private loginService: LoginServiceService) {
    this.loginService.getUserRole.subscribe(() => {
      this.setNavbarItems();
    });
    this.logoutService.logout.subscribe(() => {
      this.setNavbarItems();
    });
  }

  setNavbarItems = () => {
    this.role = localStorage.getItem('roles');
    if (this.role === '' || !this.role) {
      this.items = [
        {
          label: 'Login',
          icon: 'pi pi-fw pi-sign-in',
          routerLink: '/login',
        },
      ];
    } else {
      this.items = [
        {
          label: 'Set basket of goods',
          icon: 'pi pi-fw pi-shopping-bag',
          routerLink: '/basket',
          visible: this.role.split(",").includes("ROLE_BANKER"),
        },
        {
          label: 'Credit card request',
          icon: 'pi pi-fw pi-credit-card',
          routerLink: '/request',
          visible: this.role.split(",").includes("ROLE_CLIENT") || this.role.split(",").includes("ROLE_CLIENT"),
        },
        {
          label: 'Make transaction',
          icon: 'pi pi-fw pi-paypal',
          routerLink: '/make-transaction',
          visible: this.role.split(",").includes("ROLE_CLIENT") || this.role.split(",").includes("ROLE_CLIENT"),
        },
        {
          label: 'Credit cards',
          icon: 'pi pi-fw pi-money-bill',
          routerLink: '/cards',
          visible: this.role.split(",").includes("ROLE_CLIENT") || this.role.split(",").includes("ROLE_CLIENT"),
        },
        {
          label: 'Logout',
          icon: 'pi pi-fw pi-sign-out',
          routerLink: '/logout',
          visible: this.role.split(",").includes("ROLE_BANKER") || this.role.split(",").includes("ROLE_CLIENT"),
        },
        
      ];
    }
  };

  items: MenuItem[];

    ngOnInit() {
      this.setNavbarItems();
    }
  }

    
