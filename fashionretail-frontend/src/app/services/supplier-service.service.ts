import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Supplier} from '../modals/Supplier';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class SupplierServiceService {

  constructor(private http: HttpClient) {
//    this.userUrl = 'http://localhost:8089/api/v1/supplier';
  }

  updateSupplier(supplier: Supplier, id: number): Observable<Supplier> {
    const url = 'http://localhost:8089/api/v1/supplier/2';
    const updatedUrl = '${url}/2';
    return this.http.put<Supplier>(url, supplier, httpOptions);
  }

  getSupplier(): Observable<Supplier> {
    const url = 'http://localhost:8089/api/v1/supplier/2';
    const updatedUrl = '${url}/2';
    return this.http.get<Supplier>(url);
  }
}
