import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderNavComponent } from './ui/header-nav/header-nav.component';
import { FooterComponent } from './ui/footer/footer.component';
import { LoginComponent } from './ui/login/login.component';
import { SignUpComponent } from './ui/sign-up/sign-up.component';
import { AboutComponent } from './ui/about/about.component';
import { ContactComponent } from './ui/contact/contact.component';
import { FormsModule } from '@angular/forms';
import { MatRadioModule } from '@angular/material/radio';
import { LoginService } from './services/login.service';
import { HttpBaseService } from './services/http-base.service';
import { NavigationHomeComponent } from './navigation-home/navigation-home.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthService } from './services/auth.service';
import { AuthHttpInterceptorService } from './services/auth-http-interceptor.service';
import { AuthInterceptor } from './services/auth.interceptor';
import { FeaturesComponent } from './ui/features/features.component';
import { HomeComponent } from './ui/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderNavComponent,
    FooterComponent,
    LoginComponent,
    HomeComponent,
    SignUpComponent,
    AboutComponent,
    ContactComponent,
    NavigationHomeComponent,
    FeaturesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    MatRadioModule,
    HttpClientModule,
  ],
  providers: [
    LoginService,
    HttpBaseService,
    AuthService,
    AuthHttpInterceptorService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
