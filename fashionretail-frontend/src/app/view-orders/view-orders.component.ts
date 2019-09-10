import { Component, OnInit } from '@angular/core';
import { IOrder } from '../order';
import { OrderService } from '../order.service';
@Component({
  selector: 'app-view-orders',
  templateUrl: './view-orders.component.html',
  styleUrls: ['./view-orders.component.css']
})
export class ViewOrdersComponent implements OnInit {

  public receivedOrders: IOrder[];
  constructor(private _orderService: OrderService) { }

  ngOnInit() {
    this._orderService.getOrders().subscribe(data=>{this.receivedOrders=data; console.log("orders: "); console.log(this.receivedOrders);});
  }

}
