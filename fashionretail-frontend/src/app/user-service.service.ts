import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './modals/User';
import { Observable } from 'rxjs';
import { Designer } from './modals/Designer';

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
  private designerUrl : string;

  constructor(private http: HttpClient) {

    this.userUrl = 'http://localhost:8090/user';
    this.designerUrl = 'http://localhost:8080/designs';

   }

   saveUser(user : User) : Observable<User>{

     return this.http.post<User>(this.userUrl,user,httpOptions);
   }

   public getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl);
  }

   saveDesigns(designs : Designer) : Observable<Designer>{

      return this.http.post<Designer>(this.designerUrl,designs,httpOptions);
   }

  // constructor(private http: HttpClient) {
  //   this.userUrl = 'http://localhost:8088/user';
  // }
  // saveUser(user : User) : Observable<User>{
  //   return this.http.post<User>(this.userUrl,user,httpOptions)

  // }
}
