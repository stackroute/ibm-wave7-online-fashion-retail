import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { map } from 'rxjs/operators';
import {Product} from '../model/product';
import {Observable} from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  headers = new HttpHeaders({'Access-Control-Allow-Origin': '*'});

  constructor(private httpClient: HttpClient) {
  }

  public getAllProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>( environment.consumerUrl + '/api/v1/product', {headers: this.headers});
  }
}
