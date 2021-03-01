import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { HttpBaseService } from 'src/app/services/http-base.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class DistrictOfficeService {
  constructor(private http: HttpBaseService, private _auth: AuthService) {}

  getReports(): Observable<any> {
    return this.http.get(
      environment.baseURL +
        environment.districtOffice +
        `/${environment.reports}` +
        `/${this._auth.currentUserValue.id}`
    );
  }

  putDistrictId(id: number): Observable<any> {
    return this.http.put(
      environment.baseURL +
        environment.districtOffice +
        `/${environment.applications}` +
        `/${this._auth.currentUserValue.id}`,
      id
    );
  }

  putCentres(id: number, inventory: number): Observable<any> {
    return this.http.put(
      environment.baseURL +
        environment.districtOffice +
        `/${environment.centres}?inventory=${inventory}`,
      id
    );
  }

  getApplications(): Observable<any> {
    return this.http.get(
      environment.baseURL +
        environment.districtOffice +
        `/${environment.applications}` +
        `/${this._auth.currentUserValue.id}`
    );
  }
  getInventory(): Observable<any> {
    return this.http.get(
      environment.baseURL +
        environment.districtOffice +
        `/${environment.inventory}` +
        `/${this._auth.currentUserValue.id}`
    );
  }

  putInventory(inventory: number): Observable<any> {
    return this.http.put(
      environment.baseURL +
        environment.districtOffice +
        `/${environment.inventory}` +
        `/${this._auth.currentUserValue.id}`,
      inventory
    );
  }

  getCentres(): Observable<any> {
    return this.http.get(
      environment.baseURL +
        environment.districtOffice +
        `/${environment.centres}` +
        `/${this._auth.currentUserValue.id}`
    );
  }
}
