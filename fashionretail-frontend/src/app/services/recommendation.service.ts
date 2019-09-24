import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { Manufacturer } from '../models/Manufacturer';
import { Supplier } from '../models/Supplier';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {
  headers = new HttpHeaders({'Access-Control-Allow-Origin': '*'});

  constructor(private httpClient: HttpClient) {
  }
  public getProducts(id:string): Observable<Product[]> {
    const url=environment.recommendationUrl+"/product/";
    return this.httpClient.get<Product[]>(url+id, {headers: this.headers});

  }
  public getManufacturers():Observable<Manufacturer[]>{
    const url= environment.recommendationUrl+"/getmanufacturers";
    return this.httpClient.get<Manufacturer[]>(url,{headers: this.headers});
  }
  public getSuppliers():Observable<Supplier[]>{
    const url= environment.recommendationUrl+"/getsuppliers";
    return this.httpClient.get<Supplier[]>(url,{headers: this.headers});
  }
}
