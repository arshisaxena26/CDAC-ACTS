import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { VaccinationCentreService } from '../../services/vaccination-centre.service';

@Component({
  selector: 'app-vaccination-centre-inventory',
  templateUrl: './vaccination-centre-inventory.component.html',
  styleUrls: ['./vaccination-centre-inventory.component.scss']
})
export class VaccinationCentreInventoryComponent implements OnInit,OnDestroy {

   capacity:number = 0;
   stock:number = 0;
   nullText: any;
   subscription: Subscription | undefined;

  constructor(private centreService:VaccinationCentreService) { }


  ngOnInit(): void {
    this.updateCapacityAndStock();
  }

  updateCapacityAndStock(){
    this.subscription = this.centreService.getCapacityAndStock().subscribe(
      (res:any) => {
        this.capacity = res.centreCapacity;
        this.stock = res.centreInventory;
        if(this.capacity == 0 && this.stock == 0)
          this.nullText = "Centre Not Approved";
      }
    );
  }

  updateCapacity(){
    this.subscription = this.centreService.putCapacity(this.capacity).subscribe(
      (res:any) => {
        alert("Capacity Updated");
      }
    );
  }

  updateStock(){
    this.subscription = this.centreService.putStock(this.stock).subscribe(
      (res:any) => {
        alert("Stock Updated");
      }
    );
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
