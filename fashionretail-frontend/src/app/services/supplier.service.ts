import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Supplier} from '../models/Supplier';
import {Observable} from 'rxjs';
import { environment } from 'src/environments/environment';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class SupplierService {

  constructor(private http: HttpClient) {
//    this.userUrl = 'http://localhost:8089/api/v1/supplier';
  }

  updateSupplier(supplier: Supplier, id: string): Observable<Supplier> {
    const url = environment.supplierUrl + '/supplier';
    const updatedUrl = '${url}/2';
    return this.http.put<Supplier>(url, supplier, httpOptions);
  }

  getSupplier(): Observable<Supplier> {
    const url = environment.supplierUrl + '/supplier/2';
    const updatedUrl = '${url}/2';
    return this.http.get<Supplier>(url);
  }
}
