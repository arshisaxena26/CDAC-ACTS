import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { BeneficiaryService } from '../../services/beneficiary.service';

@Component({
  selector: 'app-beneficiary-apply-for-vaccination',
  templateUrl: './beneficiary-apply-for-vaccination.component.html',
  styleUrls: ['./beneficiary-apply-for-vaccination.component.scss'],
})
export class BeneficiaryApplyForVaccinationComponent
  implements OnInit, OnDestroy {
  subscription: Subscription | undefined;

  constructor(
    private beneficiaryService: BeneficiaryService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  applyForVaccination(beneficiaryDetails: NgForm) {
    this.subscription = this.beneficiaryService
      .applyForVaccinationService(beneficiaryDetails.value)
      .subscribe((res: any) => {
        this.router.navigate(['beneficiary/appointments']);
      });
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
