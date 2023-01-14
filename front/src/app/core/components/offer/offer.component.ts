import { CoreService } from './../../services/core.service';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css'],
})
export class OfferComponent implements OnInit {
  @Input()
  postId: string = '';

  @Input()
  toggleClickOffer: boolean = false;

  allOffers: any = [];

  ngOnInit(): void {
    this.getAllOffers();
  }

  constructor(private coreService: CoreService) {}

  // getAllComments
  getAllOffers() {
    this.coreService.getAllOffers(this.postId).subscribe(
      (res) => {
        console.log(res);
        this.allOffers = res;
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
