import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IOrder } from './order';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
 providedIn: 'root'
})
export class OrderService {
 headers = new HttpHeaders({'Access-Control-Allow-Origin': '*'});
 public data: string;
 private _url : string="http://172.23.238.218:8188/api/v1/order/8";
 constructor(private http: HttpClient) { }
 getOrders() : Observable<IOrder[]>
{
    return this.http.get<IOrder[]>(this._url);
}
submit(mapping)
{
  return this.http.post("http://172.23.238.218:8188/materials",mapping);
}
updateOrder(order:IOrder){
 return this.http.put(this._url,order,{headers: this.headers});
}
}