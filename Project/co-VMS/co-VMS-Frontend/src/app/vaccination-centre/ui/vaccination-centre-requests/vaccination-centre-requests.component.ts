import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { VaccinationCentreService } from '../../services/vaccination-centre.service';

@Component({
  selector: 'app-vaccination-centre-requests',
  templateUrl: './vaccination-centre-requests.component.html',
  styleUrls: ['./vaccination-centre-requests.component.scss'],
})
export class VaccinationCentreRequestsComponent implements OnInit, OnDestroy {
  adhaarNumber: string = '';
  name: string | undefined;
  age: number | undefined;
  appointmentDate: string | undefined;
  status: string | undefined;
  showDetails: boolean = false;
  subscription: Subscription | undefined;

  constructor(private centreService: VaccinationCentreService) {}

  ngOnInit(): void {}

  getBeneficiary(adhaarNumber: string) {
    this.subscription = this.centreService
      .getBeneficiaryDetails(this.adhaarNumber)
      .subscribe((res: any) => {
        this.name = res.name;
        this.age = res.age;
        this.appointmentDate = res.appointmentDate;
        if (res.status === true) this.status = 'Active';
        else this.status = 'Inactive';
      });
    this.showDetails = true;
  }

  vaccinate(adhaarNumber: string) {
    this.subscription = this.centreService
      .setVaccinationStatus(this.adhaarNumber)
      .subscribe((res: any) => {
        this.showDetails = false;
        this.adhaarNumber = '';
      });
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
