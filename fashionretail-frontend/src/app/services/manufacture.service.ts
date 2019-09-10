import {Injectable} from '@angular/core';
import {HttpHeaders, HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BasePrice} from '../models/BasePrice';
import {ManufacturerOrder} from '../models/ManufacturerOrder';
import {Manufacturer} from '../models/Manufacturer';
import {environment} from 'src/environments/environment';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ManufactureService {


  constructor(private httpClient: HttpClient) {
  }

  updateManufacture(id: string, manufacture: Manufacturer): Observable<Manufacturer> {
    const url = environment.manufacturerUrl + '/manufacture';
    const updateUrl = `${url}/1`;
    return this.httpClient.put<Manufacturer>(updateUrl, manufacture, httpOptions);
  }

  getManufacture(): Observable<Manufacturer> {
    const url = environment.manufacturerUrl + '/manufacture/1';
    const getUrl = `${url}/5`;
    return this.httpClient.get<Manufacturer>(url);
  }

  saveBasePrice(baseprice: BasePrice): Observable<BasePrice> {
    // const url="http://localhost:8090/baseprice";
    const url = environment.workflowUrl + '/activiti/manufacturer';
    // const updateUrl=`${url}/5`
    return this.httpClient.post<BasePrice>(url, baseprice, httpOptions);
  }

  getAllBasePrice(): Observable<BasePrice> {
    const url = environment.manufacturerUrl + '/baseprice';
    // const getUrl=`${url}/5`
    return this.httpClient.get<BasePrice>(url);
  }

  getManufactureOrder(): Observable<ManufacturerOrder> {
    const url = environment.manufacturerUrl + '/manufacture';
    return this.httpClient.get<ManufacturerOrder>(url);
  }
}
