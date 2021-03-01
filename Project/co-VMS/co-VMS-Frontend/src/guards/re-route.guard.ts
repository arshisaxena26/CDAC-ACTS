import { Injectable } from '@angular/core';
import {
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  UrlTree,
  Router,
} from '@angular/router';
import { Observable } from 'rxjs';
import { Role } from 'src/models/role';

@Injectable({
  providedIn: 'root',
})
export class ReRouteGuard implements CanActivate {
  constructor(private _router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    let currentUserData = sessionStorage.getItem('currentUser');
    if (currentUserData) {
      let role = JSON.parse(currentUserData).role;

      if (role == Role.Admin) {
        this._router.navigate(['admin/dashboard']);
        return true;
      } else if (role == Role.Beneficiary) {
        this._router.navigate(['beneficiary/dashboard']);
        return true;
      } else if (role == Role.District) {
        this._router.navigate(['district_office/dashboard']);
        return true;
      } else if (role == Role.Centre) {
        this._router.navigate(['vaccination-centre/dashboard']);
        return true;
      } else {
        this._router.navigate(['landing']);
        return true;
      }
    } else {
      this._router.navigate(['landing']);
      return true;
    }
  }
}
