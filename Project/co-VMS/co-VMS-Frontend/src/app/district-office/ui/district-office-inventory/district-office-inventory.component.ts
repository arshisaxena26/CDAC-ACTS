import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { DistrictOfficeService } from '../../services/district-office.service';

@Component({
  selector: 'app-district-office-inventory',
  templateUrl: './district-office-inventory.component.html',
  styleUrls: ['./district-office-inventory.component.scss'],
})
export class DistrictOfficeInventoryComponent implements OnInit, OnDestroy {
  stock: number = 0;
  subscription: Subscription | undefined;
  constructor(private districtService: DistrictOfficeService) {}

  ngOnInit(): void {
    this.subscription = this.districtService
      .getInventory()
      .subscribe((res: any) => {
        this.stock = res;
      });
  }

  updateStock() {
    this.subscription = this.districtService
      .putInventory(this.stock)
      .subscribe((res: any) => {
        alert('Stock Updated');
      });
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
