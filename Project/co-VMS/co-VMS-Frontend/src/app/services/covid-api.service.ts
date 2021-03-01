import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { CovidApiDTO } from 'src/models/covidApiDTO';

@Injectable({
  providedIn: 'root'
})
export class CovidApiService {

  constructor(private http:HttpClient) { }

  getCountryWiseDetails() {
    return this.http.get<CovidApiDTO>(`${environment.baseURL}` + environment.covid + 'country');
  }

  getStateWiseData(stateName: string) {
    return this.http.get<CovidApiDTO>(`${environment.baseURL}` + environment.covid + stateName);
  }

  getDistrictWiseData(officeId: number) {
    return this.http.get<CovidApiDTO>(`${environment.baseURL}` + environment.covid + `district/`+ officeId);
  }
}
