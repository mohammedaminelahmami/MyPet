import {cities} from './../../interfaces/cities';
import {category} from './../../interfaces/types';
import {CoreService} from './../../services/core.service';
import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnInit,
  OnChanges, SimpleChanges,
} from '@angular/core';
import { FormControl, FormGroup} from "@angular/forms";
import {Observable, Subscriber} from "rxjs";
import {Post} from "../../interfaces/post";
import {img} from "../../interfaces/testim";

@Component({
  selector: 'app-modal-edit-post',
  templateUrl: './modal-edit-post.component.html',
  styleUrls: ['./modal-edit-post.component.css'],
})
export class ModalEditPostComponent implements OnInit, OnChanges {
  allCities: any = cities;
  alltypes: any = category;
  @Input() modalToggle: boolean = false;
  @Input() getOnePost: any = [];
  @Output() callParent = new EventEmitter();
  imgg: string = img;
  formGroupEdit: FormGroup = new FormGroup<any>({})

  constructor(private coreService: CoreService) {}

  ngOnInit() {
    this.formGroupEdit = new FormGroup({
      title: new FormControl(this.getOnePost.title),
      description: new FormControl(this.getOnePost.description),
      type: new FormControl(this.getOnePost.type),
      city: new FormControl(this.getOnePost.city),
      price: new FormControl(this.getOnePost.price),
      images: new FormControl(this.getOnePost.images),
      num_days: new FormControl(this.getOnePost.num_days),
    });
    this.getOnePostById();
  }

  getOnePostById(): void{
    this.coreService.getOnePostById(localStorage.getItem('idPost')!).subscribe(
      (res) => {
        // console.log(res);
        this.formGroupEdit.patchValue({
          title: res.title,
          description: res.description,
          type: res.type,
          city: res.city,
          price: res.price,
          images: res.images,
          num_days: res.num_days,
        });
      }, error =>
        console.log(error)
    );
  }

  ngOnChanges(changes: SimpleChanges): void {}

  toggleModalF() {
    this.callParent.emit();
  }

  submitFormEdit(formGroup: FormGroup): void {
    const body: Post = formGroup.value;
    body.images = this.imgg;
    // console.log(body);
    this.coreService
      .updatePost(localStorage.getItem('idPost')!, body)
      .subscribe(
        (res) => {
          console.log(res);
          this.modalToggle = false;
          location.reload();
        }, error => {
          console.log(error)
          this.modalToggle = false;
        });
  }

  myimage: Observable<any> | undefined;
  images: string = '';

  onFileChange($event: Event) {
    const fileInput = $event.target as HTMLInputElement;
    if (fileInput && fileInput.files && fileInput.files[0]) {
      const file = fileInput.files[0];
      this.convertToBase64(file);
    } else {
      // handle error or provide feedback to user
    }
  }

  // convert image to base64
  convertToBase64(file: File) {
    const observable = new Observable((subscriber: Subscriber<any>) => {
      this.readFile(file, subscriber);
    });
    observable.subscribe((d) => {
      this.myimage = d;
      this.images = d;
    });
  }

  readFile(file: File, subscriber: Subscriber<any>) {
    const filereader = new FileReader();
    filereader.readAsDataURL(file);

    filereader.onload = () => {
      subscriber.next(filereader.result);
      subscriber.complete();
    };
    filereader.onerror = (error) => {
      subscriber.error(error);
      subscriber.complete();
    };
  }
}
