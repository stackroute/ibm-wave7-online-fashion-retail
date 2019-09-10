import { Component, OnInit } from '@angular/core';
import { SupplierOrder } from '../models/SupplierOrder';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-manufacturer-dashboard',
  templateUrl: './manufacturer-dashboard.component.html',
  styleUrls: ['./manufacturer-dashboard.component.css']
})
export class ManufacturerDashboardComponent implements OnInit {

  public receivedOrders: SupplierOrder[];
  constructor(private _orderService: OrderService) { }

  ngOnInit() {
    this._orderService.getOrders().subscribe(data=>{this.receivedOrders=data; console.log("orders: "); console.log(this.receivedOrders);});
  }

}
