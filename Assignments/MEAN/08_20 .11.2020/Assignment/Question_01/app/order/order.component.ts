import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent {
  id: number;
  name: string;
  billingDate: string;
  shippingDate: string;
  total: number;

  constructor() {
    this.id = 0;
    this.name = "";
    this.billingDate = "";
    this.shippingDate = "";
    this.total = 0;
  }
}
