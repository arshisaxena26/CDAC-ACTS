import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { CovidApiService } from 'src/app/services/covid-api.service';
import { PopulateListService } from 'src/app/services/populate-list.service';
import { CovidApiDTO } from 'src/models/covidApiDTO';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss'],
})
export class AdminDashboardComponent implements OnInit {
  stateList: string | undefined;
  totalVaccinatedCount: number = 0;
  userName: any;
  public covidStateData = {} as CovidApiDTO;

  constructor(
    private _auth: AuthService,
    private listService: PopulateListService,
    private covidApi: CovidApiService,
    private _admin: AdminService
  ) {}

  ngOnInit() {
    this.userName = this._auth.currentUserValue.name;
    this.listService.getAllStates().subscribe((data: string) => {
      this.stateList = data;
    });
    this._admin.getTotalVaccinatedCount().subscribe((data) => {
      this.totalVaccinatedCount = data;
    });
  }

  getStateData(stateName: string) {
    this.covidApi.getStateWiseData(stateName).subscribe((data) => {
      this.covidStateData = data;
    });
  }
}
