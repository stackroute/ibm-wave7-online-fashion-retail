import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Manufacture } from '../modals/Manufacture';
import { Observable } from 'rxjs';
import { BasePrice } from '../modals/BasePrice';


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
  updateManufacture(id:number,manufacture:Manufacture):Observable<Manufacture>
  {
    const url="http://localhost:8090/manufacture";
    const updateUrl=`${url}/1`
   return this.httpClient.put<Manufacture>(updateUrl,manufacture,httpOptions);
  }

  getManufacture():Observable<Manufacture>
 {
   const url="http://localhost:8090/manufacture/1";
    const getUrl=`${url}/5`
    return this.httpClient.get<Manufacture>(url);
 }
 saveBasePrice(baseprice:BasePrice):Observable<BasePrice>
 {
  const url="http://localhost:8999/baseprice";
  // const updateUrl=`${url}/5`
 return this.httpClient.post<BasePrice>(url,baseprice,httpOptions);
 }

 getAllBasePrice():Observable<BasePrice>
 {
   const url="http://localhost:8999/baseprice";
    // const getUrl=`${url}/5`
    return this.httpClient.get<BasePrice>(url);
 }
}
