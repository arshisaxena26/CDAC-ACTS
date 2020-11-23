import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent {
  availablity: string;
  localPhone: string;
  globalPhone: string;

  constructor() {
    this.availablity = "(Monday to Friday, 9am to 6pm PST)";
    this.localPhone = "INDIA Toll-Free: 1-877-930-7400 ";
    this.globalPhone = "International: 1-604-637-0000 ";
  }
}
