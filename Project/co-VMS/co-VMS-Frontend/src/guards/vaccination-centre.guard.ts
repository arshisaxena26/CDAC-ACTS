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
export class VaccinationCentreGuard implements CanActivate {
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

      if (role == Role.Centre) {
        return true;
      } else {
        this._router.navigate(['home']);
        return false;
      }
    }
    return false;
  }
}
