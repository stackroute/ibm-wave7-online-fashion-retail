import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { WebStorageService, LOCAL_STORAGE } from 'angular-webstorage-service';
import { catchError } from 'rxjs/operators';
import { LoginUser } from '../modals/Login';
import { Observable, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {
  public data:any=[]

  // constructor(private http:HttpClient,@Inject(LOCAL_STORAGE) private storage: WebStorageService) { }
  // saveInLocal(key, val): void {
  //   console.log('recieved= key:' + key + 'value:' + val);
  //   this.storage.set(key, val);
  //   this.data[key]= this.storage.get(key);
  //  }

  //  getFromLocal(key): void {
  //   console.log('recieved= key:' + key);
  //   this.data[key]= this.storage.get(key);
  //   console.log(this.data);
  //  }
  constructor(private http: HttpClient){}
loginuser : LoginUser;
  
  

   authenticateUser(user:LoginUser): Observable<boolean>{
    this.loginuser = user;
    return this.http.get<boolean>(environment.loginBaseURI+'/authenticate?username='+user.email+'&password='+user.password)
    .pipe(
      catchError((error: any) =>
      {
        console.log(error);
        return throwError(error)
      }
    ))
}
getByName(email : string): Observable<any>{
  return this.http.get<any>(environment.loginBaseURI+'email/?email='+email)
}
}
