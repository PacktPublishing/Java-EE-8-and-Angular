import { Injectable } from '@angular/core';
import { User } from '../domain/user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UsersService {

  constructor(private http: HttpClient) { }

  // public getAllDummy(): Observable<Array<User>> {
  //   return this.http.get<Array<User>>('/assets/users.json');
  // }

  public getAll(): Observable<Array<User>> {
    return this.http.get<Array<User>>('http://localhost:8081/ims-users/resources/users');
  }

  public get(id: number): Observable<User> {
    return this.http.get<User>(`http://localhost:8081/ims-users/resources/users/${id}`);
  }
  
  
}
