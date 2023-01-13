import { CoreService } from './../../services/core.service';
import { Component, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-postdetails',
  templateUrl: './postdetails.component.html',
  styleUrls: ['./postdetails.component.css'],
})
export class PostdetailsComponent implements OnInit {
  ngOnInit(): void {}

  constructor(private coreService: CoreService) {}

  @Input()
  allposts: any = [];
  userId: any = localStorage.getItem('id');

  toggle: boolean[] = [
    false,
    false,
    false,
    false,
    false,
    false,
    false,
    false,
    false,
    false,
  ];

  toggleModal: boolean[] = [
    false,
    false,
    false,
    false,
    false,
    false,
    false,
    false,
    false,
    false,
  ];

  toggleModalF(index: number): void {
    this.toggleModal[index] = !this.toggleModal[index];
    this.toggle[index] = false;
  }

  toggleHandler(index: number): void {
    this.toggle[index] = !this.toggle[index];
  }

  // togglePost(idPost: number): void {
  //   this.toggle = !this.toggle;
  // }

  editPost(idPost: number): void {
    // this.coreService.editPost(idPost).subscribe((res: any) => {
    //   console.log(res);
    // });
  }

  deletePost(idPost: number, index: number): void {
    this.coreService.deletePost(idPost).subscribe(
      (res: any) => {
        // console.log(res);
        this.allposts = this.allposts.filter(
          (post: any) => post.id_post !== idPost
        );
        this.toggle[index] = false;
        this.toggleModal[index] = false;
        // console.log('this.allposts', this.allposts);
      },
      (err: any) => {
        console.log(err);
      }
    );
  }
}
