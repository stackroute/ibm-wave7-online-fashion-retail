import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Product} from '../models/product';
import {Observable} from 'rxjs';
import { environment } from 'src/environments/environment';
import {ConsumerOrder} from '../models/consumer-order';

@Injectable({
  providedIn: 'root'
})
export class ConsumerService {

  headers = new HttpHeaders({'Access-Control-Allow-Origin': '*'});

  constructor(private httpClient: HttpClient) {
  }

  public viewCart(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(environment.consumerUrl + '/consumer/1/cart', {headers: this.headers});
  }
  public addToCart(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(environment.consumerUrl + '/consumer/1/cart', product, {headers: this.headers});
  }
  public removeFromCart(product: Product): Observable<Product> {
    return this.httpClient.request<Product>('delete',
      environment.consumerUrl + '/consumer/1/cart',
      {body: product, headers: this.headers});
  }
  public placeOrder(consumerOrder: ConsumerOrder) {
  return this.httpClient.post<ConsumerOrder>(environment.consumerUrl + '/consumer/order', consumerOrder, {headers: this.headers});
}

}
