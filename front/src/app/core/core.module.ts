import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormComponent } from './components/form/form.component';
import { ButtonComponent } from './components/button/button.component';
import { HomeComponent } from './pages/home/home.component';
import { ErrorpageComponent } from './pages/errorpage/errorpage.component';



@NgModule({
  declarations: [
    FormComponent,
    ButtonComponent,
    HomeComponent,
    ErrorpageComponent
  ],
  imports: [
    CommonModule
  ]
})
export class CoreModule { }
