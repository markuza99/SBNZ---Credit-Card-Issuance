import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot): boolean {
    // this will be passed from the route config
    // on the data property
    const expectedRole = route.data['expectedRoles'];
    // decode the token to get its payload
    const tokenPayload = localStorage.getItem('roles');

    if (!localStorage.getItem('username')) {
      this.router.navigateByUrl('/login');
      return false;
    }
    //arr1.some(r=> arr2.includes(r))
    //arr1.some(r=> arr2.indexOf(r) >= 0)
    if (!expectedRole.some(r=> tokenPayload.split(",").indexOf(r) >= 0)) {
      if (tokenPayload.split(",").includes("ROLE_BANKER")) {
        this.router.navigateByUrl("/basket");
      } else {
        this.router.navigateByUrl("/cards");
      }
      return false;
    }
    return true;
  }
}
