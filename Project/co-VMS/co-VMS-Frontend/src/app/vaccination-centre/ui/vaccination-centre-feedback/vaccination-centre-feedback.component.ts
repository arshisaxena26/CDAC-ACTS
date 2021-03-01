import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { feedbackDTO } from 'src/models/feedbackDTO.model';
import { VaccinationCentreService } from '../../services/vaccination-centre.service';

@Component({
  selector: 'app-vaccination-centre-feedback',
  templateUrl: './vaccination-centre-feedback.component.html',
  styleUrls: ['./vaccination-centre-feedback.component.scss'],
})
export class VaccinationCentreFeedbackComponent implements OnInit, OnDestroy {
  feedbackReports: feedbackDTO[] = [];
  subscription: Subscription | undefined;

  constructor(private centreService: VaccinationCentreService) {}

  ngOnInit(): void {
    this.subscription = this.centreService
      .getFeedbackReports()
      .subscribe((res: any) => {
        this.feedbackReports = res;
      });
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
