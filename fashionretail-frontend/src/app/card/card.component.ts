import { Component, OnInit } from '@angular/core';
import { SupplierOrder } from '../models/SupplierOrder';
import { OrderService } from '../services/order.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  public receivedOrders: SupplierOrder[];
  constructor(private _orderService: OrderService, private router: Router) { }

  ngOnInit() {
    this._orderService.getOrders()
      .subscribe(data => {this.receivedOrders = data; console.log('orders: '); console.log(this.receivedOrders); });
  }

  accept(order: SupplierOrder) {
    console.log('order', order);
    order.orderStatus = 'accepted';
    this._orderService.updateOrder(order).subscribe();
  }
  reject(order: SupplierOrder) {
    console.log('order', order);
    order.orderStatus = 'rejected';
    this._orderService.updateOrder(order).subscribe();
  }


}
