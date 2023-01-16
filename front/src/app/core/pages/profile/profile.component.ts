import {Component, OnInit} from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import {CoreService} from "../../services/core.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  getUser: any;
  constructor(private coreService: CoreService) { }
  formGroup: FormGroup = new FormGroup<any>({});

  ngOnInit() {
    this.formGroup = new FormGroup({
      username: new FormControl(''),
      email: new FormControl(''),
      password: new FormControl(''),
      phone: new FormControl(''),
    });
    this.getOneUser();
  }

  getOneUser(): void{
    this.coreService.getOneUserById(localStorage.getItem('id')!).subscribe(
      (res) => {
        this.getUser = res;
        // console.log(res);
        this.formGroup.patchValue({
          username: res.username,
          email: res.email,
          password: res.password,
          phone: res.phone,
        });
      }, error =>
      console.log(error)
    );
  }

  updateUser(): void{
    this.coreService.updateUser(localStorage.getItem('id')!, this.formGroup.value).subscribe(
      (res) => {
        console.log(res);
        this.getOneUser();
      }, error =>
      console.log(error)
    );
  }
}
