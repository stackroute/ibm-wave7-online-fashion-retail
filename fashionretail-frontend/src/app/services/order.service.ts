import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SupplierOrder } from '../models/SupplierOrder';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  public data: string;
  private _url: string = environment.designerUrl + '/designs';
  constructor(private http: HttpClient) { }
  getOrders(): Observable<SupplierOrder[]> {
     return this.http.get<SupplierOrder[]>(this._url);
 }

 submit(mapping) {
  return this.http.post(environment.workflowUrl + '/activiti/add-material', mapping);
  //  return this.http.post("http://172.23.238.169:8080/activiti/add-material",mapping);
 }

}
