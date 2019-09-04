import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IOrder } from './order';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  public data: string;
  private _url : string="http://localhost:3000/orders";
  constructor(private http: HttpClient) { }
  getOrders() : Observable<IOrder[]>
 {
     return this.http.get<IOrder[]>(this._url);
 }

 submit(mapping)
 {
   return this.http.post("http://localhost:8089/api/v2/material",mapping);
 }

}
