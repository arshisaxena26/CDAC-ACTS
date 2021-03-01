import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header-nav',
  templateUrl: './header-nav.component.html',
  styleUrls: ['./header-nav.component.scss'],
})
export class HeaderNavComponent implements OnInit {
  constructor(private router: Router, private auth: AuthService) {}

  ngOnInit(): void {}

  goToLanding() {
    this.router.navigate(['landing']);
  }

  inOrOut() {
    if (this.auth.isLoggedIn()) {
      return 'Logout';
    }
    return 'Login';
  }

  performLogout() {
    if (this.inOrOut() == 'Logout') this.auth.logout();
  }
}
