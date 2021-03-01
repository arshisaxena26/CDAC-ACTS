import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-vaccination-centre-dashboard',
  templateUrl: './vaccination-centre-dashboard.component.html',
  styleUrls: ['./vaccination-centre-dashboard.component.scss'],
})
export class VaccinationCentreDashboardComponent implements OnInit {
  userName: any;

  constructor(private _auth: AuthService) {}

  ngOnInit(): void {
    this.userName = this._auth.currentUserValue.name;
  }
}
