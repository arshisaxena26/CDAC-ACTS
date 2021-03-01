import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RegisterDTO } from 'src/models/registerDTO.model';
import { HttpBaseService } from './http-base.service';

@Injectable({
  providedIn: 'root',
})
export class SignUpService {
  constructor(private http: HttpBaseService) {}

  postSignUpData(registerData: RegisterDTO): Observable<any> {
    return this.http.post(
      environment.baseURL + environment.signup,
      registerData
    );
  }
}
