import { Component, OnInit } from '@angular/core';
import {Product} from '../classes/product';

@Component({
  selector: 'app-consumer-dashboard',
  templateUrl: './consumer-dashboard.component.html',
  styleUrls: ['./consumer-dashboard.component.css']
})
export class ConsumerDashboardComponent implements OnInit {

  products: Product[] = [];

  constructor() { }

  ngOnInit() {
    this.products.push(new Product('1', 'abc', 'clothing', 'def', 764, 20, 4.5, ''));
    this.products.push(new Product('2', 'abkc', 'clomthing', 'dmef', 774, 40, 3.5, ''));
  }

}
