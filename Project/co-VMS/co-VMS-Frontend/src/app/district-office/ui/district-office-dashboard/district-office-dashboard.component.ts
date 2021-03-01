import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { CovidApiService } from 'src/app/services/covid-api.service';
import { CovidApiDTO } from 'src/models/covidApiDTO';

@Component({
  selector: 'app-district-office-dashboard',
  templateUrl: './district-office-dashboard.component.html',
  styleUrls: ['./district-office-dashboard.component.scss'],
})
export class DistrictOfficeDashboardComponent implements OnInit {
  constructor(private _auth: AuthService, private covidApi: CovidApiService) {}
  userName: any;
  officeId: any;
  covidDistrictData = {} as CovidApiDTO;

  ngOnInit(): void {
    this.userName = this._auth.currentUserValue.name;
    this.officeId = this._auth.currentUserValue.id;
    this.covidApi.getDistrictWiseData(this.officeId).subscribe((data) => {
      this.covidDistrictData = data;
    });
  }
}
