import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  isHomePage: boolean = false;
  isProfilePage: boolean = false;

  constructor(private navigation: Router) {}

  ngOnInit() {
    this.isHomePage = this.navigation.url === '/';
    this.isProfilePage = this.navigation.url === '/profile';
  }

  toggle: boolean = false;

  toggleDropDown() {
    this.toggle = !this.toggle;
  }

  logoutUser() {
    localStorage.clear();
    this.navigation.navigate(['login']);
  }
}
