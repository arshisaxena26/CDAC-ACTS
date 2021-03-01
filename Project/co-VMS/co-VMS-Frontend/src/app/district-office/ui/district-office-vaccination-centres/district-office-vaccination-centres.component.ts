import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { approvedCentreListDTO } from 'src/models/approvedCentreListDTO.model';
import { DistrictOfficeService } from '../../services/district-office.service';

@Component({
  selector: 'app-district-office-vaccination-centres',
  templateUrl: './district-office-vaccination-centres.component.html',
  styleUrls: ['./district-office-vaccination-centres.component.scss'],
})
export class DistrictOfficeVaccinationCentresComponent
  implements OnInit, OnDestroy {
  approvedCentreList: approvedCentreListDTO[] = [];

  subscription: Subscription | undefined;

  constructor(private districtService: DistrictOfficeService) { }

  ngOnInit(): void {
    this.subscription = this.districtService
      .getCentres()
      .subscribe((res: any) => {
        this.approvedCentreList = res;
      });
  }

  updateCentreInventory(id: number, inventory: number) {
    this.subscription = this.districtService
      .putCentres(id, inventory)
      .subscribe((res: any) => {
        console.log(res);
        if (res != "")
          alert('Inventory Updated');
        else{
          alert('Not enough Stock');
          location.reload();
        }
      });
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
