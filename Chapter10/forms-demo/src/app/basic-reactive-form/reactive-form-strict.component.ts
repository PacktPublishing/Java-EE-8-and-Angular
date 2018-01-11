import { Component } from '@angular/core';
import {
  FormGroup,
  FormControl,
  FormBuilder,
  Validators
}
  from '@angular/forms';
import { Phonenumber } from './phonenumber';
import { Email } from './email';
import { User } from '../user';

@Component({
  selector: 'app-reactive-form-strict',
  templateUrl: './reactive-form-strict.component.html',
  styleUrls: ['./reactive-form-strict.component.css']
})
export class ReactiveFormStrictComponent {
  public userForm: FormGroup;

  constructor(fb: FormBuilder) {
    /* 
    Validates form input both in sync and async manner 
    Phonenumber and Email are custom validators
    */
    this.userForm = fb.group({      
      email: [null, Validators.email, Email.unique],
      phone: [null, Phonenumber.indiaPhone],
      name: fb.group({
        first: [''],
        last: ['']
      })
    });

    /* If we were loading the User from a service */
    // let theUser = new User('a@a.com',919999999);
    // this.userForm.setValue(theUser);

    this.userForm.patchValue( {
      email: 'a@a.com'
    })

    this.subscribeToFormChanges();
  }

  onSave() {
    console.log('value', this.userForm.value);
    console.log('email', this.userForm.value.email);
    console.log('phone', this.userForm.value.phone);
  }

  reset() {
    this.userForm.reset();
  }

  updatePhone() {
    (<FormControl>this.userForm.controls['phone'])
      .setValue('91');
  }

  subscribeToFormChanges() {
    this.userForm.valueChanges.subscribe(val => {
        console.log('changes', val);
    });
  }

}
