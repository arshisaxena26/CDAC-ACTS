import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { DistrictOfficeService } from '../../services/district-office.service';

@Component({
  selector: 'app-district-office-reports',
  templateUrl: './district-office-reports.component.html',
  styleUrls: ['./district-office-reports.component.scss']
})
export class DistrictOfficeReportsComponent implements OnInit,OnDestroy {
  count:number = 0;
  subscription: Subscription | undefined;
  constructor(private districtService:DistrictOfficeService) { }

  ngOnInit(): void {
    this.subscription=this.districtService.getReports().subscribe(
      (res:any)=>{
        this.count=res;
      }
    )
    ;
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

}
