import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';

@Component({
    selector: 'app-basic-form',
    templateUrl: './basic-form.component.html',
    styleUrls: ['./basic-form.component.css']
})
export class BasicFormComponent {
    users: Array<User>;
    user: User;

    constructor() {
        this.users = new Array<User>();
        this.user = new User(null, null);
    }

    onSave(userForm: NgForm) {
        console.log(userForm.valid);
        let newUser = new User(this.user.email, this.user.phone);
        this.users.push(newUser);
    }
}
