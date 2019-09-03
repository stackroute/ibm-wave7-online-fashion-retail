import { Component, OnInit } from '@angular/core';
// import { IOrder } from '../order';
import { IOrder } from '../order';
import { OrderService } from '../order.service';
// import { Manufacture } from '../order.service';



// @Component({
//   selector: 'app-card',
//   templateUrl: './card.component.html',
//   styleUrls: ['./card.component.css']
// })
// export class CardComponent implements OnInit {

//   public receivedOrders: Manufacture[];
//   constructor(private _orderService: Manufacture) { }

//   ngOnInit() {
//     this._orderService.getAllmanufacture().subscribe(data=>{this.receivedOrders=data; console.log("orders: "); console.log(this.receivedOrders);});
//   }

// }

// import { IOrder } from '../order';
// import { OrderService } from '../order.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  public receivedOrders: IOrder[];
  constructor(private _orderService: OrderService) { }

  ngOnInit() {
    this._orderService.getOrders().subscribe(data=>{this.receivedOrders=data; console.log("orders: "); console.log(this.receivedOrders);});
  }

}
