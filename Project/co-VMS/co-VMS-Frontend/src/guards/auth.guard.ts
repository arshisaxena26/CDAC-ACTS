import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private authService: AuthService) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    let loginStatus, currentUserData;
    currentUserData = sessionStorage.getItem('currentUser');

    if (route.url[0].path == 'login' && currentUserData) {
      this.router.navigate(['home']);
      return false;
    }
    if (route.url[0].path == 'login' && !currentUserData) {
      return true;
    }

    if (currentUserData) {
      loginStatus = true;
    } else {
      this.router.navigate(['home']);
      loginStatus = false;
    }
    return loginStatus;
  }
}
