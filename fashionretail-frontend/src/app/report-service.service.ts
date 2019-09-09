import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
// import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class ReportServiceService {

  constructor(private http:HttpClient) { }

  public getReport(){
     return this.http.get("http://localhost:8192/user/report");
  }

  public getDesignReport(){
    return this.http.get("http://localhost:8195/design/reports");
  }
//
//   public getAllUsers(): Observable<User[]> {
//       return this.http.get<User[]>(this.userUrl);
//     }
}
