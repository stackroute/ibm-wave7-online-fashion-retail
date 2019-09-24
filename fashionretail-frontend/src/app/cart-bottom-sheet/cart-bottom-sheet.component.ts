import {Component, Inject, OnInit} from '@angular/core';
import {MAT_BOTTOM_SHEET_DATA, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import {Product} from '../models/product';
import {MatSnackBar} from '@angular/material/snack-bar';
import {ConsumerService} from '../services/consumer.service';
import {Router} from '@angular/router';
import {InterComponentDataService} from '../services/inter-component-data.service';
import {of} from 'rxjs';

@Component({
  selector: 'app-cart-bottom-sheet',
  templateUrl: './cart-bottom-sheet.component.html',
  styleUrls: ['./cart-bottom-sheet.component.css']
})
export class CartBottomSheetComponent implements OnInit {

  total = 0;
  loginId;

  constructor(private consumerService: ConsumerService,
              private _bottomSheetRef: MatBottomSheetRef<CartBottomSheetComponent>,
              @Inject(MAT_BOTTOM_SHEET_DATA) public data: Product[],
              private _snackBar: MatSnackBar,
              private router: Router,
              private interComponentDataService: InterComponentDataService) {}

  ngOnInit(): void {
    this.interComponentDataService.currentId.subscribe(data => {this.loginId = data; this.calculateTotal();})
  }

  openLink(event: MouseEvent): void {
    this.interComponentDataService.changeCart(this.data);
    this._bottomSheetRef.dismiss(this.data);
    event.preventDefault();
    this.router.navigateByUrl('consumer/shipping');
  }

  removeFromCart(product: Product) {
    for ( let i = 0; i < this.data.length; i++) {
      if ( this.data[i] === product) {
        this.data.splice(i, 1);
        i--;
        break;
      }
    }
    this.removeCart(product);
    this.openSnackBar('removed from your cart');
    this.calculateTotal();
  }


  public removeCart(product: Product) {
    this.consumerService.removeFromCart(product,this.loginId).subscribe(data => {
    });
  }

  openSnackBar(message: string, ) {
    this._snackBar.open(message, 'okay', {
      duration: 700,
    });
  }

  calculateTotal() {
    this.total = 0;
    for ( const item of this.data) {
      this.total += item.price - item.price * item.discount / 100;
    }
  }
}
