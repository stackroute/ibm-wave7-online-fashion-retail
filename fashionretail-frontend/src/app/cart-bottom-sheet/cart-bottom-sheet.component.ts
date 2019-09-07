import {Component, Inject, OnInit} from '@angular/core';
import {MAT_BOTTOM_SHEET_DATA, MatBottomSheetRef} from "@angular/material/bottom-sheet";
import {Product} from "../classes/product";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ConsumerService} from "../services/consumer.service";

@Component({
  selector: 'app-cart-bottom-sheet',
  templateUrl: './cart-bottom-sheet.component.html',
  styleUrls: ['./cart-bottom-sheet.component.css']
})
export class CartBottomSheetComponent implements OnInit {

  constructor(private consumerService: ConsumerService,
              private _bottomSheetRef: MatBottomSheetRef<CartBottomSheetComponent>,
              @Inject(MAT_BOTTOM_SHEET_DATA) public data: Product[],
              private _snackBar: MatSnackBar) {}

  ngOnInit(): void {
  }

  openLink(event: MouseEvent): void {
    this._bottomSheetRef.dismiss(this.data);
    event.preventDefault();
  }

  removeFromCart(product: Product){
    for( let i = 0; i < this.data.length; i++){
      if ( this.data[i] === product) {
        this.data.splice(i, 1);
        i--;
        break;
      }
    }
    this.removeCart(product);
    this.openSnackBar("removed from your cart");
  }


  public removeCart(product: Product) {
    this.consumerService.removeFromCart(product).subscribe(data => {
    });
  }

  openSnackBar(message: string,) {
    this._snackBar.open(message, 'okay', {
      duration: 700,
    });
  }

}
