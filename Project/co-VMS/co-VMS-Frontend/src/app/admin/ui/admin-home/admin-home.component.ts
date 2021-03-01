import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.scss'],
})
export class AdminHomeComponent implements OnInit {
  constructor(private router: Router) {}
  adminNav: any[] = [];
  ngOnInit(): void {
    this.adminNav = [
      {
        name: 'Dashboard',
        route: 'admin/dashboard',
        data: null,
      },
      {
        name: 'Reports',
        route: 'admin/reports',
        data: null,
      },
      {
        name: 'D.O Applications',
        route: 'admin/district_office_applications',
        data: null,
      },
    ];
  }
}
