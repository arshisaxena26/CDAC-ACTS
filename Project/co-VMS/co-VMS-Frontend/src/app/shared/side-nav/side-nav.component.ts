import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'cov-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.scss'],
})
export class SideNavComponent implements OnInit {
  @Input() sideNavItems: any;
  constructor(private _router: Router) {}

  ngOnInit(): void {}

  navigateTo(route: any) {
    this._router.navigate([route]);
  }
}
