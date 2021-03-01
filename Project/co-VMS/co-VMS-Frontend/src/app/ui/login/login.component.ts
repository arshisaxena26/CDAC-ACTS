import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { LoginService } from 'src/app/services/login.service';
import { UserDTO } from 'src/models/userDTO.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit, OnDestroy {
  public user = {} as UserDTO;
  loginFailed: boolean | undefined;
  subscription: Subscription | undefined;
  errorText: any;

  constructor(
    private _authService: AuthService,
    private router: Router,
    private loginService: LoginService
  ) {}

  ngOnInit() {
    this._authService.currentUserSubject.subscribe((val) => {});
  }

  login(userCredentials: NgForm) {
    this.subscription = this._authService
      .login(userCredentials.value.email, userCredentials.value.password)
      .subscribe(
        (res: any) => {
          this.loginFailed = false;
          this.user = JSON.parse(res);
          this.goToRoleBasedHome();
        },
        (err: any) => {
          this.loginFailed = true;
          if (err.status == 401) this.errorText = 'Invalid email or password';
        }
      );
  }

  goToRoleBasedHome() {
    if (this.user.role == 'ADMIN') {
      this.router.navigate(['admin/dashboard']);
    } else if (this.user.role == 'DISTRICT') {
      this.router.navigate(['district_office/dashboard']);
    } else if (this.user.role == 'CENTRE') {
      this.router.navigate(['vaccination_centre/dashboard']);
    } else if (this.user.role == 'BENEFICIARY') {
      this.router.navigate(['beneficiary/dashboard']);
    } else {
      this.router.navigate(['login']);
    }
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
