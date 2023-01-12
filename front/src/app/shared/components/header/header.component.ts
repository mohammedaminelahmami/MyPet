import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  constructor(private navigation: Router) {}

  toggle: boolean = false;

  toggleDropDown() {
    this.toggle = !this.toggle;
  }

  logoutUser() {
    localStorage.clear();
    this.navigation.navigate(['login']);
  }
}
