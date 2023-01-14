import { CoreService } from './../../services/core.service';
import {
  Component,
  ElementRef,
  HostListener,
  Input,
  OnInit,
} from '@angular/core';

@Component({
  selector: 'app-postdetails',
  templateUrl: './postdetails.component.html',
  styleUrls: ['./postdetails.component.css'],
})
export class PostdetailsComponent implements OnInit {
  ngOnInit(): void {}

  constructor(
    private coreService: CoreService,
    private elementRef: ElementRef
  ) {}

  @Input()
  allposts: any = [];
  userId: any = localStorage.getItem('id');
  checkStillOpen: boolean = false;
  // openModalDiv: any = document.getElementById('openModalDiv');

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

  @HostListener('document:click', ['$event'])
  public onClick(event: MouseEvent): void {
    if (
      this.toggleModal.includes(true) &&
      event.target &&
      (event.target as HTMLElement).id !== 'editpost' &&
      !this.elementRef.nativeElement.contains(event.target)
    ) {
      // console.log('outside click');
      this.toggleModal = this.toggleModal.map((item: boolean) => false);
    }
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

  commentHandler(): void {
    console.log('comment clicked');
  }
}
