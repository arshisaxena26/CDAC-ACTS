import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation-home',
  templateUrl: './navigation-home.component.html',
  styleUrls: ['./navigation-home.component.scss']
})
export class NavigationHomeComponent implements OnInit {

  constructor(private _router: Router) {
    this._router.navigate(['landing']);
   }

  ngOnInit(): void {
  }

}
