import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import {Address} from '../models/address';

@Injectable({
  providedIn: 'root'
})
export class InterComponentDataService {
  private addressSource = new BehaviorSubject(new Address('', '', '', '', '', '', '', '', ''));
  currentAddress = this.addressSource.asObservable();

  constructor() { }

  changeAddress(message: Address) {
    this.addressSource.next(message);
  }
}
