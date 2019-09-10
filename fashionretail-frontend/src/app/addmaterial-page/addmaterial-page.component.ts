import { Component, OnInit } from '@angular/core';
import { OrderService } from '../order.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Supplier } from '../supplier';
import { Material } from '../material';
import { Mapping } from '../mapping';

@Component({
  selector: 'app-addmaterial-page',
  templateUrl: './addmaterial-page.component.html',
  styleUrls: ['./addmaterial-page.component.css']
})
export class AddmaterialPageComponent implements OnInit {

  constructor(private _orderService: OrderService, private activatedRoute : ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }
  name;
  
  submit(name,price,quantity,category)
  {
    let supplier = new Supplier(1,"nilakshi","nilakshi@gmail.com","bangalore","5")
    let material= new Material(2,category,name,"")
    let mapping = new Mapping(1,quantity,price,material,supplier)
    
    this._orderService.submit(mapping).subscribe(data => {this.name = data;});
  }

}
