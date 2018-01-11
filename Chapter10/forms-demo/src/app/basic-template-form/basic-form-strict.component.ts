import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';

@Component({
  selector: 'app-basic-form-strict',
  templateUrl: './basic-form-strict.component.html',
  styleUrls: ['./basic-form-strict.component.css']
})
export class BasicFormStrictComponent {
  users: Array<User>;
  user: User;

  constructor() {
    this.users = new Array<User>();
    this.user = new User(null, null);
  }

  onSave(f: NgForm) {
    console.log('user', this.user);
    console.log('valid?', f.valid);
    if (f.valid) {
      let newUser = new User(this.user.email, this.user.phone);
      this.users.push(newUser);
      f.reset();
    }
  }
}
