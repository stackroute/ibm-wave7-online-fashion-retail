import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { environment } from 'src/environments/environment';
// import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private http: HttpClient) { }

  public getReport() {
     return this.http.get(environment.reportsUrl + '/user/report');
  }

  public getDesignReport() {
    return this.http.get(environment.reportsUrl + '/design/reports');
  }
}
