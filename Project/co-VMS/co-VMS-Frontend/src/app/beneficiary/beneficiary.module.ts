import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { BeneficiaryHomeComponent } from './ui/beneficiary-home/beneficiary-home.component';
import { BeneficiaryDashboardComponent } from './ui/beneficiary-dashboard/beneficiary-dashboard.component';
import { BeneficiaryApplyForVaccinationComponent } from './ui/beneficiary-apply-for-vaccination/beneficiary-apply-for-vaccination.component';
import { BeneficiaryAppointmentsComponent } from './ui/beneficiary-appointments/beneficiary-appointments.component';
import { BeneficiaryFeedbackComponent } from './ui/beneficiary-feedback/beneficiary-feedback.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';

const routes: Routes = [
  {
    path: '',
    component: BeneficiaryHomeComponent,
    children: [
      { path: 'dashboard', component: BeneficiaryDashboardComponent },
      {
        path: 'apply_for_vaccination',
        component: BeneficiaryApplyForVaccinationComponent,
      },
      { path: 'appointments', component: BeneficiaryAppointmentsComponent },
      { path: 'feedback', component: BeneficiaryFeedbackComponent },
    ],
  },
];

@NgModule({
  declarations: [
    BeneficiaryHomeComponent,
    BeneficiaryDashboardComponent,
    BeneficiaryApplyForVaccinationComponent,
    BeneficiaryAppointmentsComponent,
    BeneficiaryFeedbackComponent,
  ],
  imports: [CommonModule, SharedModule, FormsModule, RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [],
})
export class BeneficiaryModule {}
