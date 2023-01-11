import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  registerHandler(item: any) {
    // console.log(item); call the service
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
