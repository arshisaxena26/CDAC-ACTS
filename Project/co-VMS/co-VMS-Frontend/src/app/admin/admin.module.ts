import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AdminService } from './services/admin.service';
import { AdminHomeComponent } from './ui/admin-home/admin-home.component';
import { DistrictOfficeApplicationsComponent } from './ui/admin-district-office-applications/district-office-applications.component';
import { AdminReportComponent } from './ui/admin-reports/admin-report.component';
import { AdminDashboardComponent } from './ui/admin-dashboard/admin-dashboard.component';
import { SharedModule } from '../shared/shared.module';
import { FormsModule } from '@angular/forms';

const routes: Routes = [
  {
    path: '',
    component: AdminHomeComponent,
    children: [
      { path: 'dashboard', component: AdminDashboardComponent },
      { path: 'reports', component: AdminReportComponent },
      {
        path: 'district_office_applications',
        component: DistrictOfficeApplicationsComponent,
      },
    ],
  },
];

@NgModule({
  declarations: [
    AdminHomeComponent,
    AdminReportComponent,
    DistrictOfficeApplicationsComponent,
    AdminDashboardComponent,
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(routes),
    FormsModule,
  ],
  exports: [RouterModule],
  providers: [AdminService],
})
export class AdminModule {}
