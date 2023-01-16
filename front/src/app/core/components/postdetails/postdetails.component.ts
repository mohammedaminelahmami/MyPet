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
  getOne: any = [];
  // openModalDiv: any = document.getElementById('openModalDiv');

  toggle: boolean[] = [false, false, false, false, false, false, false];

  toggleModal: boolean[] = [false, false, false, false, false, false, false];

  toggleOffer: boolean[] = [false, false, false, false, false, false, false];

  toggleModalF(index: number, idpost: string): void {
    this.toggleModal[index] = !this.toggleModal[index];
    this.toggle[index] = false;
    this.getOneP(idpost);
    localStorage.setItem('idPost', idpost);
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
      (event.target as HTMLElement).id !== 'upload' &&
      !this.elementRef.nativeElement.contains(event.target)
    ) {
      // console.log('outside click');
      this.toggleModal = this.toggleModal.map((item: boolean) => false);
    }
  }

  getOneP(idpost: string) {
    this.coreService.getOnePostById(idpost).subscribe(
      (res) => {
        this.getOne = res;
        // console.log('data', this.getOne);
      },
      (err) => {
        console.log(err);
      }
    );
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

  commentHandler(index: number): void {
    this.toggleOffer[index] = !this.toggleOffer[index];
  }
}
