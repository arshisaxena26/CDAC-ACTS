import { Injectable } from '@angular/core';
import { User } from './login/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  user = [
    new User("haley", "pass1"),
    new User("bob", "pass2"),
    new User("grace", "pass3"),
    new User("rob", "pass4"),
    new User("hannah", "pass5"),
  ];
  message = "Invalid Credentials.Try Again!";

  authenticateUser(user: User): string {
    for (let item of this.user) {
      if (user.username == item.username && user.password == item.password)
        this.message = "Login Successful!";
    }
    return this.message;
  }
}
