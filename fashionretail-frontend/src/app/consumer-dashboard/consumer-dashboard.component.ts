import {Component, OnInit} from '@angular/core';
import {Product} from '../classes/product';
import {ActivatedRoute} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {ProductService} from '../services/product.service';
import {MatBottomSheet, MatBottomSheetConfig} from "@angular/material/bottom-sheet";
import {CartBottomSheetComponent} from "../cart-bottom-sheet/cart-bottom-sheet.component";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ConsumerService} from "../services/consumer.service";

@Component({
  selector: 'app-consumer-dashboard',
  templateUrl: './consumer-dashboard.component.html',
  styleUrls: ['./consumer-dashboard.component.css']
})
export class ConsumerDashboardComponent implements OnInit {

  products: Product[] = [];
  cart: Product[] = [];

  constructor(private productService: ProductService,
              private consumerService: ConsumerService,
              private matBottomSheet: MatBottomSheet,
              private httpClient: HttpClient,
              private _snackBar: MatSnackBar) {
  }

  public getProducts() {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
    });
  }

  public getCart() {
    this.consumerService.viewCart().subscribe(data => {
      this.cart = data;
    });
  }

  public addCart(product: Product) {
    this.consumerService.addToCart(product).subscribe(data => {
    });
  }

  ngOnInit() {
    this.getProducts();
    this.getCart();
  }

  addToCart(product: Product): void {
    console.log(product);
    console.log(this.cart);
    if (this.cartContains(this.cart,product)) {
      console.log("in");
      this.openSnackBar("product already in your cart");
    } else {
      console.log("elese");
      this.cart.push(product);
      this.addCart(product);
      this.openSnackBar("added to cart");
    }
  }

  openBottomSheet(): void {
    // const config: MatBottomSheetConfig = {
    // };
    this.matBottomSheet.open(CartBottomSheetComponent,
      {
        data: this.cart,
      });
  }

  openSnackBar(message: string,) {
    this._snackBar.open(message, 'okay', {
      duration: 1000,
    });
  }

  cartContains(cart: Product[], p2:Product) {
    var i = cart.length;
    while (i--) {
      if (cart[i].id === p2.id && cart[i].name === p2.name && cart[i].designer.name === p2.designer.name) {
        return true;
      }
    }
    return false;
  }
}
