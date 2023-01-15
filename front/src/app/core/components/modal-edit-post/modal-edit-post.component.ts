import { cities } from './../../interfaces/cities';
import { category } from './../../interfaces/types';
import { CoreService } from './../../services/core.service';
import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnInit,
  OnChanges, SimpleChanges,
} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-modal-edit-post',
  templateUrl: './modal-edit-post.component.html',
  styleUrls: ['./modal-edit-post.component.css'],
})
export class ModalEditPostComponent implements OnInit, OnChanges {
  allCities: any = cities;
  alltypes: any = category;

  constructor(private coreService: CoreService) {}
  ngOnInit() {}
  ngOnChanges(changes:SimpleChanges): void {}

  @Input() modalToggle: boolean = false;
  @Input() getOnePost: any = [];
  @Output() callParent = new EventEmitter();

  toggleModalF() {
    this.callParent.emit();
  }

  formGroupEdit: FormGroup = new FormGroup({
    title: new FormControl(this.getOnePost.title),
    description: new FormControl(this.getOnePost.description),
    type: new FormControl(this.getOnePost.type),
    city: new FormControl(this.getOnePost.city),
    price: new FormControl(this.getOnePost.price),
    images: new FormControl(this.getOnePost.images),
    num_days: new FormControl(this.getOnePost.num_days),
  });

  submitFormEdit(): void {
    console.log(this.formGroupEdit.value);
    // this.coreService
    //   .updatePost(localStorage.getItem('idPost')!, formGroup.value)
    //   .subscribe(
    //     (res) => {
    //       console.log(res);
    //     },
    //     (err) => {
    //       console.log(err);
    //     }
    //   );
  }
}
