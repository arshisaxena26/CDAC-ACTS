import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-beneficiary-dashboard',
  templateUrl: './beneficiary-dashboard.component.html',
  styleUrls: ['./beneficiary-dashboard.component.scss'],
})
export class BeneficiaryDashboardComponent implements OnInit {
  userName: any;
  constructor(private _auth: AuthService) {}

  ngOnInit(): void {
    this.userName = this._auth.currentUserValue.name;
  }
}
