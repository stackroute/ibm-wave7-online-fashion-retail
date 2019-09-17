import { Component, OnInit } from '@angular/core';
import {Product} from '../models/product';
import {InterComponentDataService} from '../services/inter-component-data.service';
import {Address} from '../models/address';
import {ConsumerOrder} from '../models/consumer-order';
import {ConsumerService} from '../services/consumer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  paid = false;
  total = 0;
  cart: Product[] = [];
  address: Address;
  consumerOrder: ConsumerOrder = new ConsumerOrder();
  constructor(private interComponentDataService: InterComponentDataService,
              private consumerService: ConsumerService,
              private router: Router) { }

  ngOnInit() {
    this.interComponentDataService.currentCart.subscribe(cart => {this.cart = cart;
                                                                  console.log(this.cart);
                                                                  this.calculateTotal();
                                                                  console.log(this.total); });
    this.interComponentDataService.currentAddress.subscribe(address => this.address = address);
  }

  calculateTotal() {
    this.total = 0;
    for ( const item of this.cart) {
      this.total += item.price - item.price * item.discount / 100;
    }
  }

  pay() {
    this.consumerOrder.date = new Date();
    const num = Math.floor(Math.random() * (999999 - 100000)) + 100000;
    this.consumerOrder.id = num.toString();
    this.consumerOrder.consumerId = '1';
    this.consumerOrder.products = this.cart;
    this.consumerOrder.shippingAddress = this.address;
    this.consumerOrder.totalAmount = this.total;
    this.consumerOrder.status = 'placed';
    this.consumerService.placeOrder(this.consumerOrder).subscribe(data => {});
    this.paid = true;
    setTimeout(() => {
        this.router.navigateByUrl('consumer');
      },
      3000);
  }
}
