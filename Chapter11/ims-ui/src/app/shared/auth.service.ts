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
        localStorage.setItem('token', tokenResult);
        this.user = new User();
        this.user.name = userCreds.username;

        this.router.navigate(['issues']);
      },
      error => {
        console.log('login failed', error);
      });
  }

  /* Logout in AuthService simply removes token */
  public logout() {
    localStorage.removeItem('token');
    this.router.navigate(['login']);
  }

  public get currentUser(): User {
    return this.user;
  }

}
