import { NgModule } from '@angular/core';
import { Routes, RouterModule, NavigationError } from '@angular/router';
import { AdminGuard } from 'src/guards/admin.guard';
import { AuthGuard } from 'src/guards/auth.guard';
import { BeneficiaryGuard } from 'src/guards/beneficiary.guard';
import { DistrictOfficeGuard } from 'src/guards/district-office.guard';
import { ReRouteGuard } from 'src/guards/re-route.guard';
import { VaccinationCentreGuard } from 'src/guards/vaccination-centre.guard';
import { NavigationHomeComponent } from './navigation-home/navigation-home.component';
import { AboutComponent } from './ui/about/about.component';
import { ContactComponent } from './ui/contact/contact.component';
import { FeaturesComponent } from './ui/features/features.component';
import { HomeComponent } from './ui/home/home.component';
import { LoginComponent } from './ui/login/login.component';
import { SignUpComponent } from './ui/sign-up/sign-up.component';

const routes: Routes = [
  {
    path: 'admin',
    loadChildren: () =>
      import('./admin/admin.module').then((m) => m.AdminModule),
    canActivate: [AuthGuard, AdminGuard],
  },
  {
    path: 'beneficiary',
    loadChildren: () =>
      import('./beneficiary/beneficiary.module').then(
        (m) => m.BeneficiaryModule
      ),
    canActivate: [AuthGuard, BeneficiaryGuard],
  },
  {
    path: 'district_office',
    loadChildren: () =>
      import('./district-office/district-office.module').then(
        (m) => m.DistrictOfficeModule
      ),
    canActivate: [AuthGuard, DistrictOfficeGuard],
  },
  {
    path: 'vaccination_centre',
    loadChildren: () =>
      import('./vaccination-centre/vaccination-centre.module').then(
        (m) => m.VaccinationCentreModule
      ),
    canActivate: [AuthGuard, VaccinationCentreGuard],
  },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'landing', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'features', component: FeaturesComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'sign-up', component: SignUpComponent },
  { path: 'login', component: LoginComponent, canActivate: [AuthGuard] },
  {
    path: 'home',
    component: NavigationHomeComponent,
    canActivate: [ReRouteGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
