import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { BeneficiaryService } from '../../services/beneficiary.service';

@Component({
  selector: 'app-beneficiary-feedback',
  templateUrl: './beneficiary-feedback.component.html',
  styleUrls: ['./beneficiary-feedback.component.scss']
})
export class BeneficiaryFeedbackComponent implements OnInit,OnDestroy {
  subscription: Subscription | undefined;

  constructor(private beneficiaryService: BeneficiaryService) { }

  ngOnInit(): void {
  }

  beneficiaryFeedback(feedback:NgForm) {
    this.subscription = this.beneficiaryService
      .feedbackService(feedback.value)
      .subscribe(
        (res: any) => {
          alert("Feedback Submitted");
        }
      );
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
