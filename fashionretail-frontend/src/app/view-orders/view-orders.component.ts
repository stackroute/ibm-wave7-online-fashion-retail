import { Component, OnInit } from '@angular/core';
import { SupplierOrder } from '../models/SupplierOrder';
import { OrderService } from '../services/order.service';
@Component({
  selector: 'app-view-orders',
  templateUrl: './view-orders.component.html',
  styleUrls: ['./view-orders.component.css']
})
export class ViewOrdersComponent implements OnInit {

  public receivedOrders: SupplierOrder[];
  constructor(private _orderService: OrderService) { }

  ngOnInit() {
    this._orderService.getOrders().subscribe(data => {this.receivedOrders = data; console.log('orders: '); console.log(this.receivedOrders); });
  }
  complete(order: SupplierOrder) {
    console.log('order', order);
    order.orderStatus = 'completed';
    this._orderService.updateOrder(order).subscribe();
  }

}
