import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Supplier } from '../models/Supplier';
import { Material } from '../models/Material';
import { Mapping } from '../models/Mapping';
import { OrderService } from '../services/order.service';
import { InterComponentDataService } from '../services/inter-component-data.service';
import { UserService } from '../services/user.service';
import {SupplierService} from "../services/supplier.service";
import {Observable} from "rxjs";


@Component({
  selector: 'app-addmaterial-page',
  templateUrl: './addmaterial-page.component.html',
  styleUrls: ['./addmaterial-page.component.css']
})
export class AddmaterialPageComponent implements OnInit {
  mapping: Mapping[];
  name;
  supplier:Supplier;
  constructor(private _orderService: OrderService, private activatedRoute: ActivatedRoute, private router: Router,private intercomponentService: InterComponentDataService,private userService: UserService,private supplierService : SupplierService) { }

  ngOnInit() {
   this.supplierService.getAllMaterials(this.userService.loginCredentials.email).subscribe(data => this.mapping = data);
  }


  submit(name, price, quantity, category) {
    this.intercomponentService.currentSupplier.subscribe(data => (this.supplier =data ))
    const num1 = Math.floor(Math.random() * (999999 - 100000)) + 100000;
       const num2 = Math.floor(Math.random() * (999999 - 100000)) + 100000;
    const material = new Material(num1.toString(), category, name, '');
    const mapping = new Mapping(num2.toString(), quantity, price, material, this.supplier, '');

    this._orderService.submit(mapping).subscribe(data => {
      console.log(data);
      this.name = data; });
  }
  viewProfile(){
    console.log("hgfhdgfj");
    console.log("jjjj: ",this.userService.loginCredentials.userId);
    let loginId =this.userService.loginCredentials.userId;
    console.log("loginid: ",loginId);
    this.router.navigate(['/supplierviewprofile'],{queryParams : {loginId}});
  }


}
