import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Supplier } from '../models/Supplier';
import { Material } from '../models/Material';
import { Mapping } from '../models/Mapping';
import { OrderService } from '../services/order.service';


@Component({
  selector: 'app-addmaterial-page',
  templateUrl: './addmaterial-page.component.html',
  styleUrls: ['./addmaterial-page.component.css']
})
export class AddmaterialPageComponent implements OnInit {
  name;
  constructor(private _orderService: OrderService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }


  submit(name, price, quantity, category) {
    const supplier = new Supplier('1', 'nilakshi', 'nilakshi@gmail.com', 'bangalore', '5');
    const material = new Material('2', category, name, '');
    const mapping = new Mapping('1', quantity, price, material, supplier, '');

    this._orderService.submit(mapping).subscribe(data => {this.name = data; });
  }

}
