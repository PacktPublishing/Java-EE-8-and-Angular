import { Injectable } from '@angular/core';
import { User } from '../domain/user';

import { JwtHelperService } from '@auth0/angular-jwt';
import { Credential } from '../domain/credential';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Router } from '@angular/router';

@Injectable()
export class AuthService {
  private BASE_URL = 'http://localhost:8081/ims-users/resources';
  private user: User;

  constructor(private jwtHelper: JwtHelperService,
    private http: HttpClient, private router: Router) { }

  public get authenticated(): boolean {
    const token = this.jwtHelper.tokenGetter();
    if (token) {
      // Check if saved token has not expired
      return !this.jwtHelper.isTokenExpired(token);
    }
    return false;
  }

  public login(userCreds: Credential) {
    let url: string = `${this.BASE_URL}/users/authenticate`;
    return this.http.post(url, userCreds,
        { responseType: 'text' }
    ).subscribe(
      tokenResult => {
        let result = JSON.parse(tokenResult);
        localStorage.setItem('token', result.token);
        localStorage.setItem('id', result.id);
        localStorage.setItem('username', userCreds.username);

        this.user = new User();
        this.user.id = result.id;
        this.user.name = userCreds.username;
        console.log(this.user);
        this.router.navigate(['issues']);
      },
      error => {
        console.log('login failed', error);
      });
  }

  /* Logout in AuthService simply removes token */
  public logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('id');
    localStorage.removeItem('username');

    this.router.navigate(['login']);
  }

  public get currentUser(): User {
    if(this.user && this.user.id) {
      return this.user;
    }

    this.user = new User();
    this.user.id = Number(localStorage.getItem('id'));
    this.user.name = localStorage.getItem('username');

    return this.user;
  }

}
