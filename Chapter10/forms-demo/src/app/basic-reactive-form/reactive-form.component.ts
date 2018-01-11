import { Component } from '@angular/core';
import {
  FormGroup,
  FormControl,
  Validators
}
from '@angular/forms';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent {
  public userForm: FormGroup;

  constructor() {
    this.userForm = new FormGroup({
      email: new FormControl(),
      phone: new FormControl()
    });
  }

  onSave() {
    console.log('value', this.userForm.value);
    console.log('email', this.userForm.value.email);
    console.log('phone', this.userForm.value.phone);
  }

  reset() {
    this.userForm.reset();
  }

}
