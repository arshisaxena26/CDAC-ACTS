import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vaccination-centre-home',
  templateUrl: './vaccination-centre-home.component.html',
  styleUrls: ['./vaccination-centre-home.component.scss'],
})
export class VaccinationCentreHomeComponent implements OnInit {
  constructor(private router: Router) {}

  vaccinationCentreNav: any[] = [];

  ngOnInit(): void {
    this.vaccinationCentreNav = [
      {
        name: 'Dashboard',
        route: 'vaccination_centre/dashboard',
        data: null,
      },
      {
        name: 'Inventory',
        route: 'vaccination_centre/inventory',
        data: null,
      },
      {
        name: 'Requests',
        route: 'vaccination_centre/requests',
        data: null,
      },
      {
        name: 'Reports',
        route: 'vaccination_centre/reports',
        data: null,
      },
      {
        name: 'Feedback',
        route: 'vaccination_centre/feedback',
        data: null,
      },
    ];
  }
}
