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

 headers = new HttpHeaders({'Access-Control-Allow-Origin': '*'});
  public data: string;
  private _url: string = environment.manufacturerUrl + '/manufactureOrder/1';
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
    const url = environment.workflowUrl + '/manufacturer';
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

   getOrders(): Observable<ManufacturerOrder[]> {
      return this.httpClient.get<ManufacturerOrder[]>(this._url);
    }

    updateOrder(order: ManufacturerOrder) {
      return this.httpClient.put(this._url, order, {headers: this.headers});
    }
    getManufacturerById(userId: string): Observable<Manufacturer> {
      console.log('getxhghjdghjhfdghjfdfhjfdgjdhj');
      // const url = `${environment.designerUrl+"designer"}/${userId}`;
      const url = environment.manufacturerUrl + '/manufacture/' + userId;
      return this.httpClient.get<Manufacturer>(url, httpOptions);
        // .pipe(
        //   catchError(this.handleError('deleteHero'))
        // );
    }
}
