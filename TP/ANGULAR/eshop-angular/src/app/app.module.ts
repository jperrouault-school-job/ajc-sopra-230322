import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TableauFournisseurComponent } from './tableau-fournisseur/tableau-fournisseur.component';
import { FormFournisseurComponent } from './form-fournisseur/form-fournisseur.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './views/home/home.component';
import { Routes, RouterModule } from '@angular/router';
import { TodoComponent } from './views/todo/todo.component';
import { PageNotFoundComponent } from './views/page-not-found/page-not-found.component';
import { FournisseurComponent } from './views/fournisseur/fournisseur.component';
import { ProduitComponent } from './views/produit/produit.component';
import { ProduitDetailComponent } from './views/produit-detail/produit-detail.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AuthenticationInterceptor } from './authentication.interceptor';
import { LoginComponent } from './views/login/login.component';


// Configuration des routes
const routes: Routes = [
  // Chaque route a AU MINIMUM un chemin (path) et un composant (component)
  { path: 'accueil', component: HomeComponent },
  { path: 'connexion', component: LoginComponent },
  { path: 'todo', component: TodoComponent },
  { path: 'todo/:id', component: TodoComponent },
  { path: 'fournisseur', component: FournisseurComponent },
  { path: 'produit', component: ProduitComponent },
  { path: 'produit/:id', component: ProduitDetailComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

  
@NgModule({
  declarations: [
    AppComponent,
    TableauFournisseurComponent,
    FormFournisseurComponent,
    HomeComponent,
    TodoComponent,
    PageNotFoundComponent,
    FournisseurComponent,
    ProduitComponent,
    ProduitDetailComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthenticationInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
