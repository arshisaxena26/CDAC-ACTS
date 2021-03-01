import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class HttpBaseService {
  constructor(private http: HttpClient) {}

  post(route: string, data: any): Observable<any> {
    return this.http.post<any>(route, data, {
      responseType: 'text' as 'json',
    });
  }

  get(route: string): Observable<any> {
    return this.http.get<any>(route);
  }

  getById(route: string, id: any): Observable<any> {
    return this.http.get<any>(route + id);
  }

  delete(route: string, data: any): Observable<any> {
    return this.http.delete<any>(route, data);
  }

  put(route: string, data: any): Observable<any> {
    return this.http.put<any>(route, data, {
      responseType: 'text' as 'json',
    });
  }
}
