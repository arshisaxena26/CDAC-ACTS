import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { centreListDTO } from 'src/models/centreListDTO.model';
import { DistrictOfficeService } from '../../services/district-office.service';

@Component({
  selector: 'app-district-office-vc-applications',
  templateUrl: './district-office-vc-applications.component.html',
  styleUrls: ['./district-office-vc-applications.component.scss'],
})
export class DistrictOfficeVcApplicationsComponent
  implements OnInit, OnDestroy {
  centreList: centreListDTO[] = [];
  subscription: Subscription | undefined;

  constructor(private districtService: DistrictOfficeService) { }

  ngOnInit(): void {
    this.subscription = this.districtService
      .getApplications()
      .subscribe((res: any) => {
        this.centreList = res;
      });
  }

  approveCentre(id: number) {
    this.subscription = this.districtService.putDistrictId(id).
      subscribe((res: any) => {
        location.reload();
      });

  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
