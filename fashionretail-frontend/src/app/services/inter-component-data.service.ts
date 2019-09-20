import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import {Address} from '../models/address';
import {Product} from '../models/product';
import { Supplier } from '../models/Supplier';

@Injectable({
  providedIn: 'root'
})
export class InterComponentDataService {
  private idSource = new BehaviorSubject('');
  private supplierSource =  new BehaviorSubject(new Supplier('','','','',''));
  private addressSource = new BehaviorSubject(new Address('', '', '', '', '', '', '', '', ''));
  private cartSource = new BehaviorSubject<Product[]>([]);

  currentId = this.idSource.asObservable();
  currentAddress = this.addressSource.asObservable();
  currentCart = this.cartSource.asObservable();
  currentSupplier = this.supplierSource.asObservable();


  constructor() { }

  changeAddress(message: Address) {
    this.addressSource.next(message);
  }

  changeCart(message: Product[]) {
    this.cartSource.next(message);
  }

  changeId(message : string){
    this.idSource.next(message);
  }
  changeSupplier(message :Supplier)
  {
    this.supplierSource.next(message);
  }
}
