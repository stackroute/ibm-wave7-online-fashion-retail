import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../modals/User';
import { Observable } from 'rxjs';
import { Mapping } from '../modals/Mapping';
import { Manufacturer } from '../modals/Manufacturer';
import { Designer } from '../modals/Designer';
import { DesignerOrder } from '../modals/DesignerOrder';
import { Design } from '../modals/Design';


const httpOptions={
  headers: new HttpHeaders({
    'Access-Control-Allow-Origin':'*',
    'Content-Type':'application/json',
    'Authorization':'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private userUrl : string;
  private designerUrl : string;
  private materialUrl : string;
  private manufactureUrl : string;
  // private submitOrderUrl : string;

  constructor(private http: HttpClient) {

    this.materialUrl = 'http://172.23.238.218:8089/api/v2/materials';
    this.manufactureUrl = 'http://localhost:8090/manufacture';
    this.userUrl = 'http://localhost:8088/user';
    this.designerUrl = 'http://localhost:8080/designs';

   }

   saveUser(user : User) : Observable<User>{

     return this.http.post<User>(this.userUrl,user,httpOptions);
   }

   public getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl);
  }

  public getAllMaterial(): Observable<Mapping[]>{
    return this.http.get<Mapping[]>(this.materialUrl);
  }

  public getAllManufacture(): Observable<Manufacturer[]>{
    return this.http.get<Manufacturer[]>(this.manufactureUrl);
  }

   saveDesigns(designs : Designer) : Observable<Designer>{

      return this.http.post<Designer>(this.designerUrl,designs,httpOptions);
   }

   getDesignsById(): Observable<Design[]>{
     const url = `${this.designerUrl}/{{id}}`
     return this.http.get<Design[]>(url);
   }

   submitOrder(dOrder : DesignerOrder) : Observable<DesignerOrder>
   {
     console.log(dOrder);
    return this.http.request<DesignerOrder>('post','http://172.23.238.169:8081/activiti/upload',{body: dOrder,headers: new HttpHeaders({
      'Access-Control-Allow-Origin':'*',
    })});
   }

   public getAllOrders(): Observable<DesignerOrder[]>{
    return this.http.get<DesignerOrder[]>(this.designerUrl);
  }
  getDesigner():Observable<Designer>
  {
    const url="http://localhost:8080/designer";
    const getUrl=`${url}/3`
     return this.http.get<Designer>(getUrl);
      
  }
  updateDesigner(id:string,designer:Designer):Observable<Designer>{
    const url="http://localhost:8080/designer";
     const updateUrl=`${url}/3`;
    return this.http.put<Designer>(updateUrl,designer,httpOptions);
  }
  // constructor(private http: HttpClient) {
  //   this.userUrl = 'http://localhost:8088/user';
  // }
  // saveUser(user : User) : Observable<User>{
  //   return this.http.post<User>(this.userUrl,user,httpOptions)

  // }
}
