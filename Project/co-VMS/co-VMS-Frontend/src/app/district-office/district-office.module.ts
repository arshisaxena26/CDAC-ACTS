import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DistrictOfficeHomeComponent } from './ui/district-office-home/district-office-home.component';
import { DistrictOfficeReportsComponent } from './ui/district-office-reports/district-office-reports.component';
import { DistrictOfficeVcApplicationsComponent } from './ui/district-office-vc-applications/district-office-vc-applications.component';
import { DistrictOfficeVaccinationCentresComponent } from './ui/district-office-vaccination-centres/district-office-vaccination-centres.component';
import { RouterModule, Routes } from '@angular/router';
import { DistrictOfficeService } from './services/district-office.service';
import { DistrictOfficeDashboardComponent } from './ui/district-office-dashboard/district-office-dashboard.component';
import { DistrictOfficeInventoryComponent } from './ui/district-office-inventory/district-office-inventory.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';

const routes: Routes = [
  {
    path: '',
    component: DistrictOfficeHomeComponent,
    children: [
      { path: 'dashboard', component: DistrictOfficeDashboardComponent },
      { path: 'inventory', component: DistrictOfficeInventoryComponent },
      { path: 'reports', component: DistrictOfficeReportsComponent },
      {
        path: 'vc_applications',
        component: DistrictOfficeVcApplicationsComponent,
      },
      {
        path: 'vaccination_centres',
        component: DistrictOfficeVaccinationCentresComponent,
      },
    ],
  },
];

@NgModule({
  declarations: [
    DistrictOfficeHomeComponent,
    DistrictOfficeReportsComponent,
    DistrictOfficeVcApplicationsComponent,
    DistrictOfficeVaccinationCentresComponent,
    DistrictOfficeDashboardComponent,
    DistrictOfficeInventoryComponent,
  ],
  imports: [CommonModule, SharedModule, RouterModule.forChild(routes),FormsModule],
  exports: [RouterModule],
  providers: [DistrictOfficeService],
})
export class DistrictOfficeModule {}
