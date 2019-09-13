import { Component, OnInit } from '@angular/core';
import { SupplierOrder } from '../models/SupplierOrder';
import { OrderService } from '../services/order.service';
import { ManufacturerOrder } from '../models/ManufacturerOrder';
import { ManufactureService } from '../services/manufacture.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-manufacturer-dashboard',
  templateUrl: './manufacturer-dashboard.component.html',
  styleUrls: ['./manufacturer-dashboard.component.css']
})
export class ManufacturerDashboardComponent implements OnInit {

  public receivedOrders: ManufacturerOrder[];
  constructor(private manufacturerService: ManufactureService,private router: Router) { }

  ngOnInit() {
    this.manufacturerService.getOrders().subscribe(data => {this.receivedOrders = data; console.log('orders: '); console.log(this.receivedOrders); });
  }

  vieworders() {
    this.router.navigate(['/vieworders']);
  }
  
  accept(order: ManufacturerOrder) {
    console.log('order', order);
    order.orderStatus = 'accepted';
    this.manufacturerService.updateOrder(order).subscribe();
  }
  reject(order: ManufacturerOrder) {
    console.log('order', order);
    order.orderStatus = 'rejected';
    this.manufacturerService.updateOrder(order).subscribe();
  }
  viewProfile(){
    console.log("view profile clicked");
    this.router.navigate(['/manufactureviewprofile'])
  }
}
