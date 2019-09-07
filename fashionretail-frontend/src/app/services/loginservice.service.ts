import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { WebStorageService, LOCAL_STORAGE } from 'angular-webstorage-service';


@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {
  public data:any=[]

  constructor(private http:HttpClient,@Inject(LOCAL_STORAGE) private storage: WebStorageService) { }
  saveInLocal(key, val): void {
    console.log('recieved= key:' + key + 'value:' + val);
    this.storage.set(key, val);
    this.data[key]= this.storage.get(key);
   }

   getFromLocal(key): void {
    console.log('recieved= key:' + key);
    this.data[key]= this.storage.get(key);
    console.log(this.data);
   }
}
