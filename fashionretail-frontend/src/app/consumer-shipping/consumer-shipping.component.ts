import { Component, OnInit } from '@angular/core';
import {Address} from '../models/address';
import {InterComponentDataService} from '../services/inter-component-data.service';

@Component({
  selector: 'app-consumer-shipping',
  templateUrl: './consumer-shipping.component.html',
  styleUrls: ['./consumer-shipping.component.css']
})
export class ConsumerShippingComponent implements OnInit {

  addressModel = new Address('1', '', '', '', '', '', '', '', '');
  constructor(private interComponentDataService: InterComponentDataService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.interComponentDataService.changeAddress(this.addressModel);

  }
}
