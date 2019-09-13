import { Component, OnInit } from '@angular/core';
import { ManufacturerOrder } from '../models/ManufacturerOrder';
import { ManufactureService } from '../services/manufacture.service';

@Component({
  selector: 'app-manufacturer-view-orders',
  templateUrl: './manufacturer-view-orders.component.html',
  styleUrls: ['./manufacturer-view-orders.component.css']
})
export class ManufacturerViewOrdersComponent implements OnInit {

  public receivedOrders: ManufacturerOrder[];

  constructor(private manufactureService: ManufactureService) { }

  ngOnInit() {
    this.manufactureService.getOrders().subscribe(data => {this.receivedOrders = data; console.log('orders: '); console.log(this.receivedOrders); });
  }

}
