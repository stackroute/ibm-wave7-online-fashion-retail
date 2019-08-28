import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './modals/User';
import { Observable } from 'rxjs';

const httpOptions={
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private userUrl : string;

  constructor(private http: HttpClient) {
    this.userUrl = 'http://localhost:8088/user';
  }
  saveUser(user : User) : Observable<User>{
    return this.http.post<User>(this.userUrl,user,httpOptions)

  }
}
