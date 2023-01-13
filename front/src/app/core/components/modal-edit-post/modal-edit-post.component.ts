import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-modal-edit-post',
  templateUrl: './modal-edit-post.component.html',
  styleUrls: ['./modal-edit-post.component.css'],
})
export class ModalEditPostComponent {
  @Input()
  modalToggle: boolean = false;

  @Output()
  callParent = new EventEmitter();

  toggleModalF() {
    this.callParent.emit();
  }
}
