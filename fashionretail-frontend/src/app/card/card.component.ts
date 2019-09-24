import {Component, OnInit} from '@angular/core';
import {SupplierOrder} from '../models/SupplierOrder';
import {OrderService} from '../services/order.service';
import {Router} from '@angular/router';
import {UserService} from '../services/user.service';
import {Material} from "../models/Material";
import {SupplierService} from "../services/supplier.service";
import {Supplier} from "../models/Supplier";
import {Mapping} from "../models/Mapping";
import {InterComponentDataService} from "../services/inter-component-data.service";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  public receivedOrders: SupplierOrder[];
  materials: Mapping[] = [];
  supplier: Supplier;
  loginId;

  constructor(private _orderService: OrderService,
              private router: Router,
              private userService: UserService,
              private supplierService: SupplierService,
              private interComponentDataService: InterComponentDataService) {
  }

  ngOnInit() {
    this.interComponentDataService.currentId.subscribe(data => this.loginId=data);
    this.supplierService.getSupplierById(this.loginId).subscribe(data => {
      this.supplier = data;
      console.log("supplier: ",this.supplier);
      this.supplierService.getAllMaterials(this.supplier.email).subscribe(data => {
        console.log("all mappings: ",data);
        for (let mapping of data){
          if (mapping.supplier.email === this.supplier.email)
            this.materials.push(mapping);
        }
      });
    });
    this._orderService.getOrders(this.loginId)
      .subscribe(data => {
        this.receivedOrders = data;
        console.log('orders: ');
        console.log(this.receivedOrders);
      });
  }

  viewProfile() {
    console.log("hgfhdgfj");
    console.log("jjjj: ", this.userService.loginCredentials.userId);
    console.log("loginid: ", this.loginId);
    let loginId = this.loginId;
    this.router.navigate(['/supplierviewprofile'], {queryParams: {loginId}});
  }

  accept(order: SupplierOrder) {
    console.log('order', order);
    order.orderStatus = 'accepted';
    this._orderService.updateOrder(order, this.loginId).subscribe();
  }

  reject(order: SupplierOrder) {
    console.log('order', order);
    order.orderStatus = 'rejected';
    this._orderService.updateOrder(order, this.loginId).subscribe();
  }


}
