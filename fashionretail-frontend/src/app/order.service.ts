import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { IOrder } from './modals/Order';

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
}
