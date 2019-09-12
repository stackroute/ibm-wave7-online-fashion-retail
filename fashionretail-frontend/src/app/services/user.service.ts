import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/User';
import { Observable, from } from 'rxjs';
import { Mapping } from '../models/Mapping';
import { Manufacturer } from '../models/Manufacturer';
import { Designer } from '../models/Designer';
import { DesignerOrder } from '../models/DesignerOrder';
import { Design } from '../models/Design';
import { environment } from '../../environments/environment';
import { LoginUser } from '../models/LoginUser';


const httpOptions = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Origin': '*',
    'Content-Type': 'application/json',
    Authorization: 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {
  // private submitOrderUrl : string;

  constructor(private http: HttpClient) {

    this.materialUrl = environment.supplierUrl + '/materials';
    this.manufactureUrl = environment.manufacturerUrl + '/manufacture';
    this.userUrl = environment.userUrl + '/user';
    this.designerUrl = environment.designerUrl + '/designs';

   }

  private userUrl: string;
  private designerUrl: string;
  private materialUrl: string;
  private manufactureUrl: string;
  public loginCredentials: User;

  updateOrder(result: any, id: any) {
    throw new Error('Method not implemented.');
  }

   saveUser(user: User): Observable<User> {

     return this.http.post<User>(this.userUrl, user, httpOptions);
   }

   public getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl);
  }

  public getAllMaterial(): Observable<Mapping[]> {
    return this.http.get<Mapping[]>(environment.supplierUrl + '/materials');
  }

  public getAllManufacture(): Observable<Manufacturer[]> {
    return this.http.get<Manufacturer[]>(this.manufactureUrl);
  }

   saveDesigns(designs: Designer): Observable<Designer> {

      return this.http.post<Designer>(this.designerUrl, designs, httpOptions);
   }

   getDesignsById(): Observable<Design[]> {
     const url = `${this.designerUrl}/{{id}}`;
     return this.http.get<Design[]>(url);
   }

   submitOrder(dOrder: DesignerOrder): Observable<DesignerOrder> {
     console.log(dOrder);
      // return this.http.post<DesignerOrder>(environment.designerUrl+"/designs",dOrder,httpOptions);
     return this.http.post<DesignerOrder>(environment.workflowUrl + '/upload', dOrder, httpOptions);
    // return this.http.request<DesignerOrder>('post','http://172.23.238.169:8081/activiti/upload',{body: dOrder,headers: new HttpHeaders({
    //   'Access-Control-Allow-Origin':'*',
    // })});
   }

   public getAllOrders(): Observable<DesignerOrder[]> {
    return this.http.get<DesignerOrder[]>(environment.designerUrl + '/designs');
  }
  // getDesignerById(id : string): Observable<Designer> {
  //   const url = environment.designerUrl + '/designer';
  //   const getUrl = `${url}/{{id}}`;
  //   return this.http.get<Designer>(getUrl);

  // }
  getDesignerById(userId: string): Observable<User> {
    console.log('getxhghjdghjhfdghjfdfhjfdgjdhj');
    // const url = `${environment.designerUrl+"designer"}/${userId}`;
    const url = environment.userUrl + '/user/'+userId;
    return this.http.get<User>(url, httpOptions)
      // .pipe(
      //   catchError(this.handleError('deleteHero'))
      // );
  }
  updateDesigner(id: string, designer: Designer): Observable<Designer> {
    const url = environment.designerUrl + '/designer';
    const updateUrl = `${url}/3`;
    return this.http.put<Designer>(updateUrl, designer, httpOptions);
  }
  // constructor(private http: HttpClient) {
  //   this.userUrl = 'http://localhost:8088/user';
  // }
  // saveUser(user : User) : Observable<User>{
  //   return this.http.post<User>(this.userUrl,user,httpOptions)

  // }
}
