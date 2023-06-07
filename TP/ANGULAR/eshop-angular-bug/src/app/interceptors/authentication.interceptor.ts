import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {
  constructor(private srvAuth: AuthenticationService, private router: Router) { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if (this.srvAuth.isLogged()) {
      request = request.clone({
        setHeaders: {
          'Authorization': `Beare ${ this.srvAuth.token }`
        }
      });
    }

    return next.handle(request)
      .pipe(
        catchError((error: HttpErrorResponse) => {
          if (error.status == 403) {
            this.srvAuth.token = "";
            this.router.navigate([ '/connexion' ]);
          }
          
          return throwError(() => error);
        })
      );
  }
}
