import { Component, Input } from '@angular/core';
import { CoreService } from '../../services/core.service';

@Component({
  selector: 'app-postdetails',
  templateUrl: './postdetails.component.html',
  styleUrls: ['./postdetails.component.css'],
})
export class PostdetailsComponent {
  @Input()
  allposts: any = [];

  constructor(private coreService: CoreService) {}

  // ngOnInit(): void {
  //   this.getData();
  // }

  // async getData() {
  //   this.posts = await this.coreService
  //     .getAllPost({ page: 1, limit: 10 })
  //     .toPromise();
  // }

  // print(item: any) {
  //   console.log(item);
  // }
}
