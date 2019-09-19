import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Product} from '../models/product';
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
    return this.httpClient.get<Product[]>( environment.consumerUrl + '/product', {headers: this.headers});
  }
  public search(search :String):Observable<Product[]>{
    return this.httpClient.get<Product[]>(environment.consumerUrl+'/product/search?searchText='+search,{headers:this.headers});
  }
  public saveProduct(product:Product): Observable<Product> {
    return this.httpClient.post<Product>( environment.consumerUrl + '/product',product, {headers: this.headers});
  }
}
