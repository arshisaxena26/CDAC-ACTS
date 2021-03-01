import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { HttpBaseService } from 'src/app/services/http-base.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VaccinationCentreService {

  constructor(private http: HttpBaseService, private _auth: AuthService) { }

  getCapacityAndStock(): Observable<any> {
    return this.http.get(environment.baseURL + environment.vaccinationCentre + `/${environment.inventory}` + `/${this._auth.currentUserValue.id}`);
  }

  putCapacity(capacity: number): Observable<any> {
    return this.http.put(environment.baseURL + environment.vaccinationCentre + `/${environment.inventory}/capacity` + `/${this._auth.currentUserValue.id}`, capacity);
  }

  putStock(stock: number): Observable<any> {
    return this.http.put(environment.baseURL + environment.vaccinationCentre + `/${environment.inventory}/stock` + `/${this._auth.currentUserValue.id}`, stock);
  }

  getBeneficiaryDetails(adhaarNumber: string): Observable<any> {
    return this.http.get(environment.baseURL + environment.vaccinationCentre + `/${environment.requests}` + `/${this._auth.currentUserValue.id}` + `?adhaarNumber=${adhaarNumber}`);
  }

  setVaccinationStatus(adhaarNumber: string): Observable<any> {
    return this.http.get(environment.baseURL + environment.vaccinationCentre + `/${environment.requests}/status` + `?adhaarNumber=${adhaarNumber}`);
  }

  getCountOfVaccinatedBeneficiaries(): Observable<any> {
    return this.http.get(environment.baseURL + environment.vaccinationCentre + `/${environment.reports}` + `/${this._auth.currentUserValue.id}`);
  }

  getFeedbackReports(): Observable<any> {
    return this.http.get(environment.baseURL + environment.vaccinationCentre + `/${environment.feedback}` + `/${this._auth.currentUserValue.id}`);
  }
}
