import { AuthService } from './../../services/auth.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { STATUS_CODES } from 'http';
import { HttpStatusCode } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  constructor(private authService: AuthService, private navigation: Router) {}

  ngOnInit(): void {
    if (localStorage.getItem('token')) {
      this.navigation.navigate(['home']);
    }
  }

  registerUserHandler(item: any) {
    this.authService.register(item).subscribe(
      (res) => {
        this.navigation.navigate(['login']);
      },
      (err) => {
        console.log(err.error.message);
      }
    );
  }

  // Start Validation
  registerform: FormGroup = new FormGroup({
    username: new FormControl('', [
      Validators.required,
      Validators.minLength(4),
      Validators.maxLength(16),
      Validators.pattern(/^[a-zA-Z0-9]+$/),
    ]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(4),
      Validators.maxLength(16),
    ]),
    email: new FormControl('', [Validators.required, Validators.email]),
    phone: new FormControl('', [
      Validators.required,
      Validators.pattern(/^[0-9]+$/),
    ]),
  });

  get username() {
    return this.registerform.get('username');
  }

  get password() {
    return this.registerform.get('password');
  }

  get email() {
    return this.registerform.get('email');
  }

  get phone() {
    return this.registerform.get('phone');
  }
  // End Validation
}
