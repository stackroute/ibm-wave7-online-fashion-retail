import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './modals/User';
import { Observable } from 'rxjs';
import { Designer } from './modals/Designer';
import { Materials } from './modals/Materials';
import { Manufacturer } from './modals/Manufacturer';
import { Dorder } from './modals/Dorder';

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
  private materialUrl : string;
  private manufactureUrl : string;
  private submitOrderUrl : string;

  constructor(private http: HttpClient) {

    this.materialUrl = 'http://localhost:8089/material'
    this.manufactureUrl = 'http://localhost:8090/manufacture';
    this.userUrl = 'http://localhost:8090/user';
    this.designerUrl = 'http://localhost:8080/designs';

   }

   saveUser(user : User) : Observable<User>{

     return this.http.post<User>(this.userUrl,user,httpOptions);
   }

   public getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl);
  }

  public getAllMaterial(): Observable<Materials[]>{
    return this.http.get<Materials[]>(this.materialUrl);
  }

  public getAllManufacture(): Observable<Manufacturer[]>{
    return this.http.get<Manufacturer[]>(this.manufactureUrl);
  }

   saveDesigns(designs : Designer) : Observable<Designer>{

      return this.http.post<Designer>(this.designerUrl,designs,httpOptions);
   }

   submitOrder(dOrder : Dorder) : Observable<Dorder>
   {
    return this.http.post<Dorder>(this.designerUrl,dOrder,httpOptions);
   }

   public getAllOrders(): Observable<Dorder[]>{
    return this.http.get<Dorder[]>(this.designerUrl);
  }
  // constructor(private http: HttpClient) {
  //   this.userUrl = 'http://localhost:8088/user';
  // }
  // saveUser(user : User) : Observable<User>{
  //   return this.http.post<User>(this.userUrl,user,httpOptions)

  // }
}
