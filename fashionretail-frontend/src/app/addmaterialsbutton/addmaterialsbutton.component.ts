import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BasePrice } from '../modals/BasePrice';
import { ManufactureserviceService } from '../services/manufactureservice.service';


@Component({
  selector: 'app-addmaterialsbutton',
  templateUrl: './addmaterialsbutton.component.html',
  styleUrls: ['./addmaterialsbutton.component.css']
})
export class AddmaterialsbuttonComponent implements OnInit {
  public updatedbase: BasePrice;
  baseprice:BasePrice;

  constructor(private dialog:MatDialog, private manufactureService: ManufactureserviceService) { }

  ngOnInit() {
    this.manufactureService.getAllBasePrice().subscribe((data)=>{
      this.baseprice=data;
      console.log(this.baseprice)
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

  saveBasePrice(baseprice : BasePrice){
    let num=Math.floor(Math.random()* (999999 - 100000)) + 100000;
    console.log("Random number is", num);
    baseprice.id= num;
    console.log(baseprice)
    this.manufactureService.saveBasePrice(baseprice).subscribe((data)=>{
      console.log("result is ", data);
      this.manufactureService.getAllBasePrice().subscribe((data)=>{this.baseprice=data})
    });
  }

  data;
openDialog(){
    const dialogRef = this.dialog.open(manufactureAddDialog,
      {
        width : '250px',
        data:{}
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log("hi");
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
      @Inject(MAT_DIALOG_DATA) public data: any, private manufactureService: ManufactureserviceService) {}


  ngOnInit() {
  }

  onNoClick():void {
    this.dialogRef.close();
  }
 }
