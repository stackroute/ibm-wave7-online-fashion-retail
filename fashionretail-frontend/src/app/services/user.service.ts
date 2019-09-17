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

  isEmailTaken(email: string): Observable<boolean> {
    return this.http.get<boolean>(this.userUrl + '/exists', {params: {email}});
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

   submitOrder(dOrder: DesignerOrder, designerName: string): Observable<DesignerOrder> {
     console.log(JSON.stringify(dOrder));
     console.log(dOrder);
      // return this.http.post<DesignerOrder>(environment.designerUrl+"/designs",dOrder,httpOptions);
     return this.http.post<DesignerOrder>(environment.workflowUrl + '/upload', dOrder, {
       headers: new HttpHeaders({
         param: designerName,
         'Access-Control-Allow-Origin': '*',
         'Content-Type': 'application/json',
         Authorization: 'my-auth-token'
       })
     });
    // return this.http.request<DesignerOrder>('post','http://172.23.238.169:8081/activiti/upload',{body: dOrder,headers: new HttpHeaders({
    //   'Access-Control-Allow-Origin':'*',
    // })});
   }

   public getAllOrders(): Observable<DesignerOrder[]> {
    return this.http.get<DesignerOrder[]>(environment.designerUrl + '/designs');
  }
 
  getDesignerById(userId: string): Observable<Designer> {
    console.log('getxhghjdghjhfdghjfdfhjfdgjdhj');
    // const url = `${environment.designerUrl+"designer"}/${userId}`;
    const url = environment.designerUrl + '/designer/' + userId;
    return this.http.get<Designer>(url, httpOptions);
      // .pipe(
      //   catchError(this.handleError('deleteHero'))
      // );
  }
  updateDesigner(id: string, designer: Designer): Observable<Designer> {
    console.log("designer data from user service",designer)
    const url = environment.designerUrl + '/designer'+"/"+id;
    // const updateUrl = `${url}/id`;
    return this.http.put<Designer>(url, designer, httpOptions);
  }
 
}
