import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-district-office-home',
  templateUrl: './district-office-home.component.html',
  styleUrls: ['./district-office-home.component.scss'],
})
export class DistrictOfficeHomeComponent implements OnInit {
  constructor(private router: Router) {}

  districOfficeNav: any[] = [];

  ngOnInit(): void {
    this.districOfficeNav = [
      {
        name: 'Dashboard',
        route: 'district_office/dashboard',
        data: null,
      },
      {
        name: 'Inventory',
        route: 'district_office/inventory',
        data: null,
      },
      {
        name: 'Reports',
        route: 'district_office/reports',
        data: null,
      },
      {
        name: 'V.C Applications',
        route: 'district_office/vc_applications',
        data: null,
      },
      {
        name: 'Centre List',
        route: 'district_office/vaccination_centres',
        data: null,
      },
    ];
  }
}
