import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders} from "@angular/common/http";
// import {User1} from "./models/User1"
// import {LoginUser} from "./modals/Login";
import {User1} from "../modals/User1";
import {LoginUser} from "../modals/Login";
import { Observable, BehaviorSubject } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    "Content-Type": "application/json",
    Authorization: "my-auth-token"
  })
};
@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {
  private apiUrl = "http://localhost:8193/register";
  private apiUrl2 = "http://localhost:8193/authenticate";
  private user: User1;

  private loggedIn=new BehaviorSubject<boolean>(false);
  logged = this.loggedIn.asObservable();

  constructor(private httpClient:HttpClient) { }
 
  saveUser(user:User1):Observable<User1>
  {
    return this.httpClient.post<User1>(this.apiUrl, user);
  }
//public loginuser:LoginUser;


  login(data: User1): Observable<any>{
    this.loggedIn.next(true);
    return this.httpClient.post<any>(this.apiUrl2, data);
   
  }

  private apiUrl3 = "http://localhost:8193/forgot-password";
   forgotpassword(data: User1): Observable<any>{
   return this.httpClient.post<any>(this.apiUrl3,data);
 }
 private apiUrl4 = "http://localhost:8193/reset-password";
 resetpassword(data: LoginUser): Observable<any> {
   return this.httpClient.put<any>(this.apiUrl4, data);
 }
}
