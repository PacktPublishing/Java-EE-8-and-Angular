import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';

import { Issue } from '../../domain/issue';
import { User } from '../../domain/user';
import { IssuesService } from '../../shared/issues.service';
import { UsersService } from '../../shared/users.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-issue-listing',
  templateUrl: './issue-listing.component.html',
  styleUrls: ['./issue-listing.component.css']
})
export class IssueListingComponent implements OnInit {
  issues$: Observable<Array<Issue>>;

  constructor(private router: Router,
    private issuesService: IssuesService,
    private usersService: UsersService) { }

  ngOnInit() {
    // this.issuesService.getAll().subscribe(
    //   data => {
    //     console.log(data);
    //   },
    //   (err: HttpErrorResponse) => {
    //     console.log("Error occured.", err.status)
    //   }
    // );
    this.issues$ = this.issuesService.getAll();
  }

  createIssue() {
    this.router.navigate(['/issues/create']);
  }

  editIssue(issue: Issue) {
    this.router.navigate(['/issue', issue.id]);
  }

  showUserInfo(user: User) {
    this.usersService.get(user.id).subscribe(res => {
      //update and set email of user
      user.email = res.email;
    });
  }

}
