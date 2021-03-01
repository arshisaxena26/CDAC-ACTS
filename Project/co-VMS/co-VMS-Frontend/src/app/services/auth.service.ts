import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpBaseService } from './http-base.service';
import { map } from 'rxjs/operators';
import { UserDTO } from 'src/models/userDTO.model';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  public currentUserSubject: BehaviorSubject<UserDTO>;
  public currentUser: Observable<UserDTO>;

  constructor(private http: HttpBaseService) {
    this.currentUserSubject = new BehaviorSubject<UserDTO>(
      JSON.parse(sessionStorage.getItem('currentUser') || '{}')
    );
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): UserDTO {
    return this.currentUserSubject.value;
  }

  login(email: string, password: string) {
    return this.http
      .post(environment.baseURL + environment.authenticate, {
        email,
        password,
      })
      .pipe(
        map((user) => {
          let currUser = JSON.parse(user);
          if (currUser && currUser.token) {
            sessionStorage.setItem('currentUser', user);
            sessionStorage.setItem('jwtToken', currUser.token);
            this.currentUserSubject.next(user);
          }
          return user;
        })
      );
  }

  isLoggedIn(): boolean {
    let flag = true;
    if (sessionStorage.getItem('currentUser') === null) flag = false;
    return flag;
  }

  logout() {
    sessionStorage.clear();
  }
}
