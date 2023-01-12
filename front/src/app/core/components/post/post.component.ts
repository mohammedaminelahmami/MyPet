import { category } from './../../interfaces/types';
import { cities } from './../../interfaces/cities';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CoreService } from './../../services/core.service';
import { Component, OnInit, Input, Output } from '@angular/core';
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
    //
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
    type: new FormControl('', [
      Validators.required,
      Validators.pattern('/[Type]/g || /[City]/g'),
    ]),
    num_days: new FormControl('', [
      Validators.required,
      Validators.pattern('^[0-9]*$'),
    ]),
    price: new FormControl('', [
      Validators.required,
      Validators.pattern('^[0-9]*$'),
    ]),
  });

  onFileChange(event: any) {
    this.images.push(event.target.files[0].name);
  }

  createPostHandler(formgroup: FormGroup) {
    const body: Post = formgroup.value;
    body.images = this.images.join(',');

    this.coreService.createPost(body).subscribe(
      (res: any) => {
        // console.log(res);
        this.postFormGroup.get('title')?.setValue('');
        this.postFormGroup.get('description')?.setValue('');
        this.postFormGroup.get('city')?.setValue('City');
        this.postFormGroup.get('type')?.setValue('Type');
        this.postFormGroup.get('num_days')?.setValue('');
        this.postFormGroup.get('price')?.setValue('');
        this.offerCreated = true;
        this.getAllPosts(); // Recall Api
      },
      (err: any) => {
        console.log(err);
      }
    );
    console.log(body);
    this.images = [];
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
