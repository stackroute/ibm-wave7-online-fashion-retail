import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IOrder } from '../services/order';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  public receivedOrders: IOrder[];
  constructor(private _orderService: OrderService , private router: Router) { }

  ngOnInit() {
    this._orderService.getOrders().subscribe(data=>{this.receivedOrders=data; console.log("orders: "); console.log(this.receivedOrders);});
  }

  vieworders()
  {
    this.router.navigate(['/vieworders']);
  }

  accept(order: IOrder)
  {
    console.log("order",order);
    order.orderStatus="accepted";
    this._orderService.updateOrder(order).subscribe();
  }
  reject(order: IOrder)
  {
    console.log("order",order);
    order.orderStatus="rejected";
    this._orderService.updateOrder(order).subscribe();
  }
  

}
