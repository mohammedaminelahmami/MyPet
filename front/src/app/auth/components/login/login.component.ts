import { AuthService } from './../../services/auth.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  token: string = '';

  constructor(private authService: AuthService, private navigation: Router) {}

  ngOnInit(): void {
    if (localStorage.getItem('token')) {
      this.navigation.navigate(['home']);
    }
  }

  loginUserHandler(item: any) {
    this.authService.login(item).subscribe(
      (response: any) => {
        // console.log(response);
        this.token = response.accessToken;
        localStorage.setItem('token', this.token);
        localStorage.setItem('id', response.id);
        this.navigation.navigate(['home']);
      },
      (err: any) => {
        console.log(err.error.message);
      }
    );
  }

  // validation
  loginForm: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(4),
      Validators.maxLength(16),
    ]),
  });

  get email() {
    return this.loginForm.get('email');
  }

  get password() {
    return this.loginForm.get('password');
  }
  // validation
}
