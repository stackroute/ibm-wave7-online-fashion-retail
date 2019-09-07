import { Component, OnInit } from '@angular/core';
import { IOrder } from '../services/order';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-manufacturer-dashboard',
  templateUrl: './manufacturer-dashboard.component.html',
  styleUrls: ['./manufacturer-dashboard.component.css']
})
export class ManufacturerDashboardComponent implements OnInit {
 
  public receivedOrders: IOrder[];
  constructor(private _orderService: OrderService) { }

  ngOnInit() {
    this._orderService.getOrders().subscribe(data=>{this.receivedOrders=data; console.log("orders: "); console.log(this.receivedOrders);});
  }

}
 