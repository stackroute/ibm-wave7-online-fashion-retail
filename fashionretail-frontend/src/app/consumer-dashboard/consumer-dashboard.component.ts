import { Component, OnInit } from '@angular/core';
import {Product} from '../classes/product';
import {ActivatedRoute} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {ProductService} from '../services/product.service';

@Component({
  selector: 'app-consumer-dashboard',
  templateUrl: './consumer-dashboard.component.html',
  styleUrls: ['./consumer-dashboard.component.css']
})
export class ConsumerDashboardComponent implements OnInit {

  products: Product[] = [];

  constructor(private productService: ProductService, private route: ActivatedRoute, private httpClient: HttpClient) {
  }

  public getProducts() {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
    });
  }

  ngOnInit() {
    this.getProducts();
  }
}
