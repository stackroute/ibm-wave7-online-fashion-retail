import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Supplier } from '../models/Supplier';
import { Material } from '../models/Material';
import { Mapping } from '../models/Mapping';
import { OrderService } from '../services/order.service';
import { InterComponentDataService } from '../services/inter-component-data.service';


@Component({
  selector: 'app-addmaterial-page',
  templateUrl: './addmaterial-page.component.html',
  styleUrls: ['./addmaterial-page.component.css']
})
export class AddmaterialPageComponent implements OnInit {
  name;
  supplier:Supplier;
  constructor(private _orderService: OrderService, private activatedRoute: ActivatedRoute, private router: Router,private intercomponentService: InterComponentDataService) { }

  ngOnInit() {
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

}
