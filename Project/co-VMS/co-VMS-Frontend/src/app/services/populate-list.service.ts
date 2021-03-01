import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { of } from 'rxjs/internal/observable/of';
import { environment } from 'src/environments/environment';
import { District } from 'src/models/district';
import { State } from 'src/models/state';
import { StateListDTO } from 'src/models/stateListDTO';

@Injectable({
  providedIn: 'root',
})
export class PopulateListService {
  state: State[] = [];
  district: District[] = [];

  constructor(private http: HttpClient) {}

  getStates() {
    return this.http.get<State[]>(`${environment.baseURL}` + environment.state);
  }

  getDistrict(districtId: number) {
    return this.http.get<District[]>(
      `${environment.baseURL}` + environment.district + districtId
    );
  }

  getAllStates() {
    return this.http.get<string>(`${environment.baseURL}` + environment.covid + `state_list`);
  }
}
