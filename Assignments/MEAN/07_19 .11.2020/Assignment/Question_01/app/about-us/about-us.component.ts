import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.css']
})
export class AboutUsComponent {
  greeting: string;
  data: string;

  constructor() {
    this.greeting = "WELCOME";
    this.data = "At Website.com, we believe everyone deserves to have a website or online store. Innovation and simplicity makes us happy: our goal is to remove any technical or financial barriers that can prevent business owners from making their own website. We're excited to help you on your journey!";
  }
}
