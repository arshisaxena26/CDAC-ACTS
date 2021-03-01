import { HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { HttpBaseService } from 'src/app/services/http-base.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class BeneficiaryService {
  constructor(private http: HttpBaseService, private _auth: AuthService) {}

  applyForVaccinationService(beneficiaryDetails: any): Observable<any> {
    let p = `${this._auth.currentUserValue.id}`;
    return this.http.post(
      environment.baseURL +
        environment.beneficiary +
        `/${environment.applyForVaccination}` +
        '/' +
        `${this._auth.currentUserValue.id}`,
      beneficiaryDetails
    );
  }

  feedbackService(feedback: any): Observable<any> {
    return this.http.post(
      environment.baseURL +
        environment.beneficiary +
        `/${environment.feedback}` +
        `/${this._auth.currentUserValue.id}`,
      feedback
    );
  }

  getAppointment(): Observable<any> {
    return this.http.get(
      environment.baseURL +
        environment.beneficiary +
        `/${environment.appointment}` +
        `/${this._auth.currentUserValue.id}`
    );
  }
}
