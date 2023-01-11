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
  ],
  imports: [CommonModule, SharedModule],
  exports: [HomeComponent],
})
export class CoreModule {}
