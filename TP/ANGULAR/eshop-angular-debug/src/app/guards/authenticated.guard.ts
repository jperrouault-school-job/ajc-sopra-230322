import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

export const authenticatedGuard: CanActivateFn = (route, state) => {
  const srvAuth = inject(AuthenticationService);
  const authenticated = srvAuth.isLogged();
  
  if (!authenticated) {
    const router = inject(Router);
    router.navigate([ '/connexion' ]);
  }

  return true;
};
