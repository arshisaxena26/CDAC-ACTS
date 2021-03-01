import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpBaseService } from 'src/app/services/http-base.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  constructor(private http: HttpBaseService) {}

  getList(): Observable<any> {
    return this.http.get(environment.baseURL + environment.admin);
  }
  getReports(id: number): Observable<any> {
    return this.http.get(
      environment.baseURL +
        environment.admin +
        `/${environment.reports}?id=${id}`
    );
  }

  getApplications(): Observable<any> {
    return this.http.get(
      environment.baseURL + environment.admin + `/${environment.applications}`
    );
  }

  putApplications(id: number): Observable<any> {
    return this.http.put(
      environment.baseURL + environment.admin + `/${environment.applications}`,
      id
    );
  }

  getTotalVaccinatedCount(): Observable<any> {
    return this.http.get(
      environment.baseURL + environment.admin + `/vaccinated_count`
    );
  }
}
