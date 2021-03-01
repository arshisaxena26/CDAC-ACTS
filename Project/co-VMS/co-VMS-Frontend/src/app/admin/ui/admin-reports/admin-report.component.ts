import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { PopulateListService } from 'src/app/services/populate-list.service';
import { District } from 'src/models/district';
import { State } from 'src/models/state';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-admin-report',
  templateUrl: './admin-report.component.html',
  styleUrls: ['./admin-report.component.scss'],
})
export class AdminReportComponent implements OnInit, OnDestroy {
  count: number = 0;
  listState: State[] = [];
  listDistrict: District[] = [];
  subscription: Subscription | undefined;

  constructor(
    private listService: PopulateListService,
    private adminService: AdminService
  ) {}

  ngOnInit(): void {
    this.listService.getStates().subscribe((data) => {
      this.listState = data;
    });
  }

  bindDistrict(stateId: number) {
    this.listService.getDistrict(stateId).subscribe((data) => {
      this.listDistrict = data;
    });
  }

  getCount(districtId: number) {
    this.adminService.getReports(districtId).subscribe((data) => {
      this.count = data;
    });
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
