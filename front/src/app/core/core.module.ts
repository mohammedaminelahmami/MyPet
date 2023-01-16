import { SharedModule } from './../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormComponent } from './components/form/form.component';
import { ButtonComponent } from './components/button/button.component';
import { HomeComponent } from './pages/home/home.component';
import { ErrorpageComponent } from './pages/errorpage/errorpage.component';
import { FilterComponent } from './components/filter/filter.component';
import { PostComponent } from './components/post/post.component';
import { CommentComponent } from './components/comment/comment.component';
import { ReplyComponent } from './components/reply/reply.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AlertComponent } from './components/alert/alert.component';
import { PostdetailsComponent } from './components/postdetails/postdetails.component';
import { ModalEditPostComponent } from './components/modal-edit-post/modal-edit-post.component';
import { OfferComponent } from './components/offer/offer.component';
import { ProfileComponent } from './pages/profile/profile.component';

@NgModule({
  declarations: [
    FormComponent,
    ButtonComponent,
    HomeComponent,
    ErrorpageComponent,
    FilterComponent,
    PostComponent,
    CommentComponent,
    ReplyComponent,
    AlertComponent,
    PostdetailsComponent,
    ModalEditPostComponent,
    OfferComponent,
    ProfileComponent,
  ],
  imports: [CommonModule, SharedModule, FormsModule, ReactiveFormsModule],
  exports: [HomeComponent],
})
export class CoreModule {}
