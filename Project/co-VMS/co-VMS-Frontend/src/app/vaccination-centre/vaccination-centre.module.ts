import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VaccinationCentreHomeComponent } from './ui/vaccination-centre-home/vaccination-centre-home.component';
import { VaccinationCentreRequestsComponent } from './ui/vaccination-centre-requests/vaccination-centre-requests.component';
import { VaccinationCentreReportsComponent } from './ui/vaccination-centre-reports/vaccination-centre-reports.component';
import { VaccinationCentreFeedbackComponent } from './ui/vaccination-centre-feedback/vaccination-centre-feedback.component';
import { RouterModule, Routes } from '@angular/router';
import { VaccinationCentreService } from './services/vaccination-centre.service';
import { VaccinationCentreDashboardComponent } from './ui/vaccination-centre-dashboard/vaccination-centre-dashboard.component';
import { VaccinationCentreInventoryComponent } from './ui/vaccination-centre-inventory/vaccination-centre-inventory.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';

const routes: Routes = [
  {
    path: '',
    component: VaccinationCentreHomeComponent,
    children: [
      { path: 'dashboard', component: VaccinationCentreDashboardComponent },
      { path: 'inventory', component: VaccinationCentreInventoryComponent },
      { path: 'requests', component: VaccinationCentreRequestsComponent },
      { path: 'reports', component: VaccinationCentreReportsComponent },
      { path: 'feedback', component: VaccinationCentreFeedbackComponent },
    ],
  },
];

@NgModule({
  declarations: [
    VaccinationCentreHomeComponent,
    VaccinationCentreRequestsComponent,
    VaccinationCentreReportsComponent,
    VaccinationCentreFeedbackComponent,
    VaccinationCentreDashboardComponent,
    VaccinationCentreInventoryComponent,
  ],
  imports: [CommonModule, SharedModule, RouterModule.forChild(routes), FormsModule],
  exports: [RouterModule],
  providers: [VaccinationCentreService],
})
export class VaccinationCentreModule { }
