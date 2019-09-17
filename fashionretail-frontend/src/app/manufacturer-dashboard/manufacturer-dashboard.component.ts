import { Component, OnInit } from '@angular/core';
import { ManufacturerOrder } from '../models/ManufacturerOrder';
import { ManufactureService } from '../services/manufacture.service';
import {Router} from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-manufacturer-dashboard',
  templateUrl: './manufacturer-dashboard.component.html',
  styleUrls: ['./manufacturer-dashboard.component.css']
})
export class ManufacturerDashboardComponent implements OnInit {

  public receivedOrders: ManufacturerOrder[];
  constructor(private _manufactureService: ManufactureService , private router: Router,private userService : UserService) { }

  ngOnInit() {
    this._manufactureService.getOrders().subscribe(data => {this.receivedOrders = data; console.log('orders: '); console.log(this.receivedOrders); });
  }
  viewProfile(){
    console.log("hgfhdgfj");
    console.log("jjjj: ",this.userService.loginCredentials.userId);
    let loginId =this.userService.loginCredentials.userId;
    console.log("loginid: ",loginId);
    this.router.navigate(['/manufactureviewprofile'],{queryParams : {loginId}});
  }

accept(order: ManufacturerOrder) {
    console.log('order', order);
    order.orderStatus = 'accepted';
    this._manufactureService.updateOrder(order).subscribe();
  }
  reject(order: ManufacturerOrder) {
    console.log('order', order);
    order.orderStatus = 'rejected';
    this._manufactureService.updateOrder(order).subscribe();
  }

}
