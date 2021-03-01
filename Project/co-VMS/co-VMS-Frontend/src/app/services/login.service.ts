import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpBaseService } from './http-base.service';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpBaseService) {}

  getRole(userdata: any): Observable<any> {
    return this.http.post(environment.baseURL + environment.authenticate, userdata);
  }
}
