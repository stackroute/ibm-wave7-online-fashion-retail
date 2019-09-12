import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {SupplierOrder} from '../models/SupplierOrder';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  headers = new HttpHeaders({'Access-Control-Allow-Origin': '*'});
  public data: string;
  private _url: string = environment.supplierUrl + '/order/1';

  constructor(private http: HttpClient) {
  }

  getOrders(): Observable<SupplierOrder[]> {
    return this.http.get<SupplierOrder[]>(this._url);
  }

  submit(mapping) {
    return this.http.post(environment.workflowUrl + '/add-material', mapping);
  }

  updateOrder(order: SupplierOrder) {
    return this.http.put(this._url, order, {headers: this.headers});
  }
}
