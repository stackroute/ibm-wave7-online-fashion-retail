import { Component, OnInit, Inject } from '@angular/core';
import { Manufacture } from '../modals/Manufacture';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { ManufactureserviceService } from '../manufactureservice.service';

export interface DialogData{
  city: string;
  contact_number: number;
}

@Component({
  selector: 'app-manufactureviewprofile',
  templateUrl: './manufactureviewprofile.component.html',
  styleUrls: ['./manufactureviewprofile.component.css']
})
export class ManufactureviewprofileComponent implements OnInit {

  city: string;
  contact_number: number;
   public updatedManu: Manufacture;
  manufacture: Manufacture
  
  constructor(private dialog: MatDialog, private manufactureService: ManufactureserviceService) { }

  ngOnInit() {
    this.manufactureService.getManufacture().subscribe((data)=>{
      this.manufacture=data;
      console.log(this.manufacture);
    })
  }
  updateManufacture(manufacture:Manufacture) {
        console.log(manufacture);
    this.manufactureService.updateManufacture(manufacture.id,manufacture).subscribe((data)=> {
      console.log("result is ", data);
      this.manufactureService.getManufacture().subscribe(data => {this.manufacture=data})
      
    });
  }

  data;
  openDialog(manufacture:Manufacture) {
    this.updatedManu = manufacture;
    const dialogRef = this.dialog.open(manufactureEditDialog,
      {
        width : '250px',
        data:{}
      });
      dialogRef.afterClosed().subscribe(result => {
        this.data = result;
        console.log(result);
        this.updateManufacture(result);
        
      });
  }
}
  @Component({
    selector: 'app-manufactureEditDialog',
    templateUrl: 'manufactureEditDialog.html',
   })
   export class manufactureEditDialog {
     manufacture: Manufacture;
      city: string;
    contact_number: number;
   
    constructor(
      public dialogRef: MatDialogRef<manufactureEditDialog>,
      @Inject(MAT_DIALOG_DATA) public data: any, private manufactureService: ManufactureserviceService) {}
      onNoClick(): void {
        this.dialogRef.close();
      }
     
   }
