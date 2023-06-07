import { Routes } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { PageNotFoundComponent } from './views/page-not-found/page-not-found.component';
import { FournisseurComponent } from './views/fournisseur/fournisseur.component';
import { ProduitComponent } from './views/produit/produit.component';
import { LoginComponent } from './views/login/login.component';
import { authenticatedGuard } from './guards/authenticated.guard';

// Configuration des routes
export const routes: Routes = [
  // Chaque route a AU MINIMUM un chemin (path) et un composant (component)
  {
    path: 'accueil',
    component: HomeComponent,
    canActivate: [ authenticatedGuard ]
  },

  {
    path: 'connexion',
    component: LoginComponent
  },

  {
    path: 'fournisseur',
    component: FournisseurComponent,
    canActivate: [ authenticatedGuard ]
  },

  {
    path: 'produit',
    component: ProduitComponent,
    canActivate: [ authenticatedGuard ]
  },

  {
    path: '',
    redirectTo: 'accueil',
    pathMatch: 'full'
  },

  {
    path: '**',
    component: PageNotFoundComponent
  }
];