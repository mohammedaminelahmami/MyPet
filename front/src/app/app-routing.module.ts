import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './core/pages/home/home.component';
import { LoginComponent } from './auth/components/login/login.component';
import { RegisterComponent } from './auth/components/register/register.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  // {path: "about", component: AboutComponent},
  // {path: "contact", component: ContactComponent},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  // {path: "profile", component: ProfileComponent},
  // {path: "dashboard", component: DashboardComponent},
  { path: '**', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
