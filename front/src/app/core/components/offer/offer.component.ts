import { CoreService } from './../../services/core.service';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css'],
})
export class OfferComponent implements OnInit {
  userId: any = localStorage.getItem('id');
  @Input()
  postId: string = '';

  @Input()
  toggleClickOffer: boolean = false;

  allOffers: any = [];

  ngOnInit(): void {
    this.getAllOffers();
  }

  recallAfterChanges(): void {
    this.getAllOffers();
  }

  constructor(private coreService: CoreService) {}

  // getAllComments
  getAllOffers() {
    this.coreService.getAllOffers(this.postId).subscribe(
      (res) => {
        // console.log(res);
        this.allOffers = res;
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


}
