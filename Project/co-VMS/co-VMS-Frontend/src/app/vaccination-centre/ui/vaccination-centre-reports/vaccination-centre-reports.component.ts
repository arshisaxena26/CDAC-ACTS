import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { VaccinationCentreService } from '../../services/vaccination-centre.service';

@Component({
  selector: 'app-vaccination-centre-reports',
  templateUrl: './vaccination-centre-reports.component.html',
  styleUrls: ['./vaccination-centre-reports.component.scss']
})
export class VaccinationCentreReportsComponent implements OnInit, OnDestroy {

  count: number = 0;
  subscription: Subscription | undefined;

  constructor(private centreService: VaccinationCentreService) { }

  ngOnInit(): void {
    this.subscription = this.centreService.getCountOfVaccinatedBeneficiaries().subscribe(
      (res: any) => {
        this.count = res;
      }
    );
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
