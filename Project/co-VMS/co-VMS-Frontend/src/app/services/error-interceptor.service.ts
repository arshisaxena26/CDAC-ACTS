import { HttpEvent, HttpHandler, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class ErrorInterceptorService {
  constructor(private authService: AuthService) {}
  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(
      catchError((err) => {
        if ([401, 403].indexOf(err.status) !== -1) {
          this.authService.logout();
          location.reload(true);
        }

        const error = err.error.message || err.statusText;
        return throwError(error);
      })
    );
  }
}
