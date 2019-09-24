import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BasePrice } from '../models/BasePrice';
import { ManufactureService } from '../services/manufacture.service';
import {InterComponentDataService} from "../services/inter-component-data.service";


@Component({
  selector: 'app-addmaterialsbutton',
  templateUrl: './addmaterialsbutton.component.html',
  styleUrls: ['./addmaterialsbutton.component.css']
})
export class AddmaterialsbuttonComponent implements OnInit {

  constructor(private dialog: MatDialog, private manufactureService: ManufactureService, private interComponentDataService: InterComponentDataService) { }
  public updatedbase: BasePrice;
  baseprice: BasePrice;
  loginId;

  data;

  ngOnInit() {
    this.interComponentDataService.currentId.subscribe(data => {this.loginId=data;
      this.manufactureService.getAllBasePrice(this.loginId).subscribe((data1) => {
        this.baseprice = data1;
        console.log(this.baseprice);
      });
    })
  }

  // updateBasePrice(baseprice:BasePrice) {
  //   // this.manufacture.name=this.updatedName;
  //   // this.manufacture.email=this.updatedEmail;
  //   console.log(baseprice);
  //   this.manufactureService.saveBasePrice(baseprice).subscribe((data)=> {
  //     console.log("result is ", data);
  //     this.manufactureService.getAllBasePrice().subscribe(data => {this.baseprice=data})

  //   });
  // }

  saveBasePrice(baseprice: BasePrice) {
    const num = Math.floor(Math.random() * (999999 - 100000)) + 100000;
    console.log('Random number is', 'num');
    baseprice.id = 'num';
    console.log(baseprice);
    this.manufactureService.saveBasePrice(baseprice,this.loginId).subscribe((data) => {
      console.log('result is ', data);
      this.manufactureService.getAllBasePrice(this.loginId).subscribe((data) => {this.baseprice = data; });
    });
  }
openDialog() {
    const dialogRef = this.dialog.open(manufactureAddDialog,
      {
        width : '250px',
        data: {}
      });

    dialogRef.afterClosed().subscribe(result => {
        this.data = result;
        console.log(result);
        this.saveBasePrice(result);

      });
  }

}

@Component({
  selector: 'app-manufactureAddDialog',
  templateUrl: 'manufactureAddDialog.html',
 })
 export class manufactureAddDialog {
   baseprice: BasePrice;
   name: string;
   price: number;
  constructor(
    public dialogRef: MatDialogRef<manufactureAddDialog>,
    @Inject(MAT_DIALOG_DATA) public data: any, private manufactureService: ManufactureService) {}


  ngOnInit() {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
 }
