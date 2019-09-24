import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Product} from '../models/product';
import {Observable} from 'rxjs';
import { environment } from 'src/environments/environment';
import {ConsumerOrder} from '../models/consumer-order';
import { Consumer } from '../models/consumer';

@Injectable({
  providedIn: 'root'
})
export class ConsumerService {

  headers = new HttpHeaders({'Access-Control-Allow-Origin': '*'});

  constructor(private httpClient: HttpClient) {
  }

  public viewCart(userId: string): Observable<Product[]> {
    return this.httpClient.get<Product[]>(environment.consumerUrl + '/consumer/'+userId+'/cart', {headers: this.headers});
  }
  public addToCart(product: Product, userId: string): Observable<Product> {
    return this.httpClient.post<Product>(environment.consumerUrl + '/consumer/'+userId+'/cart', product, {headers: this.headers});
  }
  public removeFromCart(product: Product, userId: string): Observable<Product> {
    return this.httpClient.request<Product>('delete',
      environment.consumerUrl + '/consumer/'+userId+'/cart',
      {body: product, headers: this.headers});
  }
  public placeOrder(consumerOrder: ConsumerOrder) {
  return this.httpClient.post<ConsumerOrder>(environment.consumerUrl + '/consumer/order', consumerOrder, {headers: this.headers});
}
getConsumerById(userId: string): Observable<Consumer> {
  console.log('getxhghjdghjhfdghjfdfhjfdgjdhj');
    return this.httpClient.get<Consumer>(environment.consumerUrl + '/consumer/'+userId, {headers: this.headers});
}
}
