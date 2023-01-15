import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CoreService } from './../../services/core.service';
import { Component, Output, Input, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],
})
export class CommentComponent {
  constructor(private coreService: CoreService) {}

  @Input()
  postIdFromComment: string = '';

  @Output()
  callParent = new EventEmitter();

  functionCalledFromParent(): void {
    this.callParent.emit();
  }

  formGroupComment = new FormGroup({
    comment_body: new FormControl('', [Validators.required]),
  });

  submitNewComment(formGroup: FormGroup): void {
    if (formGroup.valid) {
      this.coreService.createOffer(this.postIdFromComment, formGroup.value).subscribe(
        (res) => {
          console.log("postIdcomment => ",this.postIdFromComment)
          this.formGroupComment.reset();
          this.functionCalledFromParent();
        },
        (err) => {
          console.log(err);
        }
      );
    }
  }
}
