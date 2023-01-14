import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CoreService } from './../../services/core.service';
import { Component, Output } from '@angular/core';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],
})
export class CommentComponent {
  constructor(private coreService: CoreService) {}

  idPost: string = '';

  formGroupComment = new FormGroup({
    comment_body: new FormControl('', [Validators.required]),
  });

  submitNewComment(formGroup: FormGroup): void {
    if (formGroup.valid) {
      this.coreService.createOffer(this.idPost, formGroup.value).subscribe(
        (res) => {
          console.log(res);
          this.formGroupComment.reset();
        },
        (err) => {
          console.log(err);
        }
      );
    }
  }
}
