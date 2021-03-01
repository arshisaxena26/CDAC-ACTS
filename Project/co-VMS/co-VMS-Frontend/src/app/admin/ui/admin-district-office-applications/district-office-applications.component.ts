import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { districtOfficeDTO } from 'src/models/districtOfficeDTO.model';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-district-office-applications',
  templateUrl: './district-office-applications.component.html',
  styleUrls: ['./district-office-applications.component.scss'],
})
export class DistrictOfficeApplicationsComponent implements OnInit, OnDestroy {
  districtList: districtOfficeDTO[] = [];

  subscription: Subscription | undefined;
  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.subscription = this.adminService
      .getApplications()
      .subscribe((res: any) => {
        this.districtList = res;
      });
  }

  approveDistrict(id: number) {
    this.subscription = this.adminService.putApplications(id).
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
