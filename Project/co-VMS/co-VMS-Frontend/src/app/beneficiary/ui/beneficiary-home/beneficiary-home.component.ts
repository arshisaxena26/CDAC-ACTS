import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-beneficiary-home',
  templateUrl: './beneficiary-home.component.html',
  styleUrls: ['./beneficiary-home.component.scss'],
})
export class BeneficiaryHomeComponent implements OnInit {
  constructor(private router: Router) {}
  beneficiaryNav: any[] = [];
  ngOnInit(): void {
    this.beneficiaryNav = [
      {
        name: 'Dashboard',
        route: 'beneficiary/dashboard',
        data: null,
      },
      {
        name: 'Feedback',
        route: 'beneficiary/feedback',
        data: null,
      },
      {
        name: 'Appointments',
        route: 'beneficiary/appointments',
        data: null,
      },
      {
        name: 'Apply',
        route: 'beneficiary/apply_for_vaccination',
        data: null,
      },
    ];
  }
}
