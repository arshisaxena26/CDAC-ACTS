import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { PopulateListService } from 'src/app/services/populate-list.service';
import { SignUpService } from 'src/app/services/sign-up.service';
import { District } from 'src/models/district';
import { RegisterDTO } from 'src/models/registerDTO.model';
import { State } from 'src/models/state';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss'],
})
export class SignUpComponent implements OnInit, OnDestroy {
  public confirmPassword: string = '';
  public signup = {} as RegisterDTO;
  submitFailed: boolean | undefined;
  errorText: any;
  subscription: Subscription | undefined;
  listState: State[] = [];
  listDistrict: District[] = [];

  constructor(
    private router: Router,
    private signupService: SignUpService,
    private listService: PopulateListService
  ) {}

  ngOnInit() {
    this.listService.getStates().subscribe((data) => {
      this.listState = data;
    });
  }

  bindDistrict(stateId: number) {
    this.listService.getDistrict(stateId).subscribe((data) => {
      this.listDistrict = data;
    });
  }

  register(newUser: NgForm) {
    if (newUser.value.password === newUser.value.confirmPassword) {
      this.signup.email = newUser.value.email;
      this.signup.password = newUser.value.password;
      this.signup.roleId = newUser.value.role;
      this.signup.name = newUser.value.name;
      this.signup.districtId = newUser.value.district;

      if (!this.signup.email) {
        this.errorText = 'Please Enter Email';
      } else if (!this.signup.password) {
        this.errorText = 'Please Enter Password';
      } else if (!this.signup.roleId) {
        this.errorText = 'Please Select Role';
      } else if (!this.signup.name) {
        this.errorText = 'Please Enter Name';
      } else if (!this.signup.districtId) {
        this.errorText = 'Please Select Dsitrict';
      }

      this.subscription = this.signupService
        .postSignUpData(this.signup)
        .subscribe(
          (res) => {
            this.submitFailed = false;
            this.router.navigate(['login']);
          },
          (err: any) => {
            this.submitFailed = true;
            if (err.status == 403) this.errorText = 'Email Already Exists';
          }
        );
    } else {
      this.submitFailed = true;
      this.errorText = 'Password Did Not Match';
    }
  }

  goToRoleBasedHome() {
    this.router.navigate(['home']);
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
