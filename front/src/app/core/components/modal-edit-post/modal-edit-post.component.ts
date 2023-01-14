import { cities } from './../../interfaces/cities';
import { category } from './../../interfaces/types';
import { FormGroup, FormControl } from '@angular/forms';
import { CoreService } from './../../services/core.service';
import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnInit,
  OnChanges,
} from '@angular/core';

@Component({
  selector: 'app-modal-edit-post',
  templateUrl: './modal-edit-post.component.html',
  styleUrls: ['./modal-edit-post.component.css'],
})
export class ModalEditPostComponent implements OnInit, OnChanges {
  allCities: any = cities;
  alltypes: any = category;

  constructor(private coreService: CoreService) {}

  ngOnChanges(changes: any): void {}

  ngOnInit(): void {}

  @Input()
  modalToggle: boolean = false;

  @Input()
  getOnePost: any = [];

  @Output()
  callParent = new EventEmitter();

  toggleModalF() {
    this.callParent.emit();
  }

  formGroupEdit = new FormGroup({
    title: new FormControl(''),
    description: new FormControl(''),
    price: new FormControl(''),
    num_days: new FormControl(''),
    city: new FormControl(''),
    type: new FormControl(''),
  });

  submitFormEdit(formGroup: FormGroup): void {
    console.log(formGroup.value);
    this.coreService
      .updatePost(localStorage.getItem('idPost')!, formGroup.value)
      .subscribe(
        (res) => {
          console.log(res);
        },
        (err) => {
          console.log(err);
        }
      );
  }
}
