import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  erreur: boolean = false;
  userForm!: FormGroup;
  usernameCtrl!: FormControl;
  passwordCtrl!: FormControl;

  constructor(title: Title, private router: Router, private formBuilder: FormBuilder) {
    title.setTitle("Se connecter");
  }
  
  ngOnInit(): void {
    this.usernameCtrl = this.formBuilder.control('', Validators.required);
    this.passwordCtrl = this.formBuilder.control('', Validators.required);

    this.userForm = this.formBuilder.group({
      username: this.usernameCtrl,
      password: this.passwordCtrl
    });
  }

  seConnecter() {
    this.erreur = false;

    this.srvAuth.login(this.usernameCtrl.value, this.passwordCtrl.value, {
      next: () => {
        this.router.navigate([ '/accueil' ]);
      },

      error: () => {
        this.erreur = true;
      }
    });
  }
}
