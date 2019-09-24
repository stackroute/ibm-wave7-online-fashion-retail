import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { DesignerOrder } from '../models/DesignerOrder';
import { Router } from '@angular/router';

@Component({
  selector: 'app-designervieworders',
  templateUrl: './designervieworders.component.html',
  styleUrls: ['./designervieworders.component.css']
})
export class DesignerviewordersComponent implements OnInit {

  orderlist: DesignerOrder[];
  constructor( private userService: UserService,
    private router : Router) { }

  ngOnInit() {
    let designer_id = this.userService.loginCredentials.userId;
    this.userService.getAllOrders(designer_id).subscribe((data) => {
      this.orderlist = data;
      console.log('orders list', this.orderlist);
      for (let order of this.orderlist){
        if(order.designOrder.orderStatus.indexOf('manufacturer_completed') !== -1)
          order.designOrder.orderStatus = 'Manufacturer Completed';
        else if(order.designOrder.orderStatus.indexOf('manufacturer_accepted') !== -1)
          order.designOrder.orderStatus = 'Manufacturer Accepted';
        else if(order.designOrder.orderStatus.indexOf('supplier_completed') !== -1)
          order.designOrder.orderStatus = 'Supplier Completed';
        else if(order.designOrder.orderStatus.indexOf('supplier_accepted') !== -1)
          order.designOrder.orderStatus = 'Supplier Accepted';
      }
    });
  }
  viewProfile(){
    let loginId =this.userService.loginCredentials.userId ;
    this.router.navigate(['/designerviewprofile'],{queryParams : {loginId}});
  }

}
