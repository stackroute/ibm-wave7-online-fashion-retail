import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BasePrice } from '../modals/BasePrice';
import { ManufacturerOrder } from '../modals/ManufacturerOrder';
import { Manufacturer } from '../modals/Manufacturer';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
     'Authorization': 'my-auth-token'
  })
 };

@Injectable({
  providedIn: 'root'
})
export class ManufactureserviceService {



  constructor(private httpClient:HttpClient) { }
  updateManufacture(id:number,manufacture:Manufacturer):Observable<Manufacturer>
  {
    const url="http://localhost:8090/manufacture";
    const updateUrl=`${url}/1`
   return this.httpClient.put<Manufacturer>(updateUrl,manufacture,httpOptions);
  }

  getManufacture():Observable<Manufacturer>
 {
   const url="http://localhost:8090/manufacture/1";
    const getUrl=`${url}/5`
    return this.httpClient.get<Manufacturer>(url);
 }
 saveBasePrice(baseprice:BasePrice):Observable<BasePrice>
 {
  const url="http://localhost:8090/baseprice";
  // const updateUrl=`${url}/5`
 return this.httpClient.post<BasePrice>(url,baseprice,httpOptions);
 }

 getAllBasePrice():Observable<BasePrice>
 {
   const url="http://localhost:8090/baseprice";
    // const getUrl=`${url}/5`
    return this.httpClient.get<BasePrice>(url);
 }
 getManufactureOrder():Observable<ManufacturerOrder>
 {
   const url="http://localhost:8090/manufacture";
   return this.httpClient.get<ManufacturerOrder>(url);
 }
}
