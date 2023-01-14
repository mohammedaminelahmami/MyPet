import { Observable, Subscriber } from 'rxjs';
import { category } from './../../interfaces/types';
import { cities } from './../../interfaces/cities';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CoreService } from './../../services/core.service';
import { Component, OnInit } from '@angular/core';
import { Post } from '../../interfaces/post';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
})
export class PostComponent implements OnInit {
  constructor(private coreService: CoreService) {}

  posts: any = [];

  ngOnInit(): void {
    this.getAllPosts();
  }

  allCities: any = cities;
  alltypes: any = category;
  offerCreated: boolean = false;
  changeDetect: boolean = false;

  images: string[] = [];

  postFormGroup = new FormGroup({
    title: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
    city: new FormControl('', [Validators.required]),
    type: new FormControl('', [Validators.required]),
    num_days: new FormControl('', [
      Validators.required,
      Validators.pattern('^[0-9]*$'),
    ]),
    price: new FormControl('', [
      Validators.required,
      Validators.pattern('^[0-9]*$'),
    ]),
    images: new FormControl('', [Validators.required]),
  });

  myimage: Observable<any> | undefined;

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
      this.images.push(d);
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
  // convert image to base64

  createPostHandler(formgroup: FormGroup) {
    const body: Post = formgroup.value;
    body.images = this.images.join('');
    console.log(body);
    if (
      formgroup.valid &&
      formgroup.get('city')?.value !== 'City' &&
      formgroup.get('type')?.value !== 'Type'
    ) {
      this.coreService.createPost(body).subscribe(
        (res: any) => {
          // console.log(res);
          this.postFormGroup.get('title')?.setValue('');
          this.postFormGroup.get('description')?.setValue('');
          this.postFormGroup.get('city')?.setValue('City');
          this.postFormGroup.get('type')?.setValue('Type');
          this.postFormGroup.get('num_days')?.setValue('');
          this.postFormGroup.get('price')?.setValue('');
          this.postFormGroup.get('images')?.setValue('');
          this.offerCreated = true;
          this.getAllPosts(); // Recall Api
          this.images = [];
        },
        (err: any) => {
          console.log(err);
        }
      );
    }
  }

  getAllPosts() {
    this.coreService.getAllPost({ page: 1, limit: 10 }).subscribe(
      (res) => {
        // console.log(res);
        this.posts = res;
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
