import { Injectable } from '@angular/core';
import { Observable, from } from 'rxjs';
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
// export class Manufacture
// {
// private manufactureUrl: string;
// constructor(private http: HttpClient)
// {
//   this.manufactureUrl='http://localhost:8090/manufacture';
// }
// public getAllmanufacture(): Observable<Manufacture[]> {
//   return this.http.get<Manufacture[]>(this.manufactureUrl);
// }

//   }

}