import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { Manufacturer } from '../models/Manufacturer';
import { Supplier } from '../models/Supplier';

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {
  headers = new HttpHeaders({'Access-Control-Allow-Origin': '*'});

  constructor(private httpClient: HttpClient) {
  }
  public getProducts(id:string): Observable<Product[]> {
    const url="http://localhost:9099/product"
    return this.httpClient.get<Product[]>(url+id, {headers: this.headers});

  }
  public getManufacturers():Observable<Manufacturer[]>{
    const url= "http://localhost:9099/getmanufacturers"
    return this.httpClient.get<Manufacturer[]>(url,{headers: this.headers});
  }
  public getSuppliers():Observable<Supplier[]>{
    const url= "http://localhost:9099/getsuppliers"
    return this.httpClient.get<Supplier[]>(url,{headers: this.headers});
  }
}
