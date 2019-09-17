import { Component, OnInit } from '@angular/core';
import { ManufacturerOrder } from '../models/ManufacturerOrder';
import { ManufactureService } from '../services/manufacture.service';

@Component({
  selector: 'app-manufacturer-view-order',
  templateUrl: './manufacturer-view-order.component.html',
  styleUrls: ['./manufacturer-view-order.component.css']
})
export class ManufacturerViewOrderComponent implements OnInit {
 public receivedOrders: ManufacturerOrder[];
  constructor(private _manufactureService: ManufactureService) { }

  ngOnInit() {
    this._manufactureService.getOrders().subscribe(data => {this.receivedOrders = data; console.log('orders: '); console.log(this.receivedOrders); });
  }

}
