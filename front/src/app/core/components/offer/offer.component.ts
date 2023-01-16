import {CoreService} from './../../services/core.service';
import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css'],
})
export class OfferComponent implements OnInit {
  userId: any = localStorage.getItem('id');
  checkPostIsVerified: boolean = false;
  @Input() postId: string = '';
  @Input() toggleClickOffer: boolean = false;
  toggleVerifyOffer: boolean = false;

  allOffers: any = [];

  ngOnInit(): void {
    this.getAllOffers();
  }

  recallAfterChanges(): void {
    this.getAllOffers();
  }

  constructor(private coreService: CoreService) {
  }

  // getAllComments
  getAllOffers() {
    this.coreService.getAllOffers(this.postId).subscribe(
      (res) => {
        this.allOffers = res;
        this.allOffers.map((item: { comment_isVerified: boolean; }) => item.comment_isVerified ? this.checkPostIsVerified = true : false)
      },
      (err) => {
        console.log(err);
      }
    );
  }

  deleteOffer(id_comment: string): void {
    this.coreService.deleteOffer(id_comment).subscribe(
      (res) => {
        console.log(res);
        this.recallAfterChanges();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  verifyOffer(id_comment: string): void {
      this.coreService.verifyOffer(id_comment).subscribe(
        (res) => {
          console.log(res);
          this.recallAfterChanges();
        },
        (err) => {
          console.log(err);
        }
      );
  }


}
