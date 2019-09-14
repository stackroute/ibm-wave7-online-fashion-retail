import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {LoginUser} from '../models/LoginUser';
import {Observable, BehaviorSubject} from 'rxjs';
import {environment} from '../../environments/environment';
import {User} from '../models/User';



const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {
  private apiUrl = environment.userUrl + '/register';
  private apiUrl2 = environment.loginUrl + '/authenticate';
  private apiUrl3 = environment.loginUrl + '/forgot-password';
  private apiUrl4 = environment.loginUrl + '/reset-password';
  private loginUser: LoginUser;

  private loggedIn = new BehaviorSubject<boolean>(false);
  logged = this.loggedIn.asObservable();

  constructor(private httpClient: HttpClient) {
  }

  saveUser(user: LoginUser): Observable<LoginUser> {
    return this.httpClient.post<LoginUser>(this.apiUrl, user);
  }

// public loginuser:LoginUser;

  login(data: LoginUser): Observable<User> {
    this.loggedIn.next(true);
    return this.httpClient.post<User>(this.apiUrl2, data);

  }
  forgotpassword(data: LoginUser): Observable<User> {
    return this.httpClient.post<User>(this.apiUrl3, data);
  }

  resetpassword(data: LoginUser): Observable<User> {
    return this.httpClient.put<User>(this.apiUrl4, data);
  }
}

