import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { User } from './user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user = new User("", "");
  message: string = "";

  constructor(private loginservice: LoginService) { }

  submit(name: string, pass: string) {
    this.user = new User(name, pass);
    this.message = this.loginservice.authenticateUser(this.user);
  }
}
