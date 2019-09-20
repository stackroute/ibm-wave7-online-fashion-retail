import { Component, OnInit } from '@angular/core';
import { ManufacturerOrder } from '../models/ManufacturerOrder';
import { ManufactureService } from '../services/manufacture.service';
import { UserService } from '../services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-manufacturer-view-order',
  templateUrl: './manufacturer-view-order.component.html',
  styleUrls: ['./manufacturer-view-order.component.css']
})
export class ManufacturerViewOrderComponent implements OnInit {
 public receivedOrders: ManufacturerOrder[];
  constructor(private _manufactureService: ManufactureService,private userService : UserService,private router: Router) { }

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


}
