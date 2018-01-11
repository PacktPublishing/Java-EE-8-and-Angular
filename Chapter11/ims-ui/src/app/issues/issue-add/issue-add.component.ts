import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { Issue } from '../../domain/issue';
import { IssuesService } from '../../shared/issues.service';
import { UsersService } from '../../shared/users.service';
import { Observable } from 'rxjs/Observable';
import { User } from '../../domain/user';

@Component({
  selector: 'app-issue-add',
  templateUrl: './issue-add.component.html',
  styleUrls: ['./issue-add.component.css']
})
export class IssueAddComponent implements OnInit {
  public issueForm: FormGroup;
  users: User[];

  constructor(private router: Router,
    private issuesService: IssuesService,
    private usersService: UsersService,
    fb: FormBuilder) {

    this.issueForm = fb.group({
      label: [null, [Validators.required, Validators.minLength(2)], null],
      description: [null, Validators.required],
      assignedTo: [null, Validators.required]
    });
  }

  ngOnInit() {
    this.usersService.getAll().subscribe(res => {
      this.users = res;
    })
  }

  reset() {
    this.issueForm.reset();
  }

  onSave() {
    console.log(this.issueForm.value);
    // let newIssue: Issue = f.value;
    // newIssue.created = new Date();
    this.issuesService.add(this.issueForm.value).subscribe(res => {
      // this.router.navigate(['issues']);
      this.reset();
    });

  }
}
