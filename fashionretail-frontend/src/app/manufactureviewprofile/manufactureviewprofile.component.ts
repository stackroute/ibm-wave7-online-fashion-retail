import { Component, OnInit, Inject } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { ManufactureService } from '../services/manufacture.service';
import { Manufacturer } from '../models/Manufacturer';
import { UserService } from '../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';

export interface DialogData {
  city: string;
  contact_number: number;
}

@Component({
  selector: 'app-manufactureviewprofile',
  templateUrl: './manufactureviewprofile.component.html',
  styleUrls: ['./manufactureviewprofile.component.css']
})
export class ManufactureviewprofileComponent implements OnInit {

  constructor(private dialog: MatDialog,
     private manufactureService: ManufactureService,
     private userService: UserService,
     private route : Router, private router : ActivatedRoute) { }

  city: string;
  contactNumber: number;
   public updatedManu: Manufacturer;

  manufacture: {
  //   id: "";
  // name: "";
  // email: "";
  // city: "";
  // specifications: "";
  // rating: 0;
  // contact_number: 0;
  // manufacturerOrders: null;
  // basePrices: null;

  };

  data;

  ngOnInit() {

    // this.manufactureService.getManufacture().subscribe((data) => {
    //   this.manufacture = data;
    //   console.log(this.manufacture);
    // });
    console.log(this.userService.loginCredentials);
    this.router.queryParams.subscribe(data => {
       let loginId = data.loginId;
       console.log("in subscribe method id is: ",loginId);
      // this.interComponent.changeId(this.loginId);
      // this.interComponent.currentId.subscribe(data => designer_id = data);
      // this.user = this.designerService.loginCredentials;
      // console.log("id of designer", this.loginId)
      // this.designer.name = this.user.name;
      // this.designer.email = this.user.email;
      // this.designer.userId = this.loginId;

      // console.log("desiger name", this.designer)
      this.manufactureService.getManufacturerById(loginId).subscribe((data) => {
        console.log("data recieved is: ",data)
        this.manufacture = data;
        console.log(this.manufacture);
      });
    })
  }
  updateManufacture(manufacture: Manufacturer) {
        console.log(manufacture);
        this.manufactureService.updateManufacture(manufacture.id, manufacture).subscribe((data) => {
      console.log('result is ', data);
      this.manufactureService.getManufacture().subscribe(data1 => {this.manufacture = data1; });

    });
  }
  openDialog(manufacture: Manufacturer) {
    this.updatedManu = manufacture;
    const dialogRef = this.dialog.open(ManufactureEditDialogComponent,
      {
        width : '250px',
        data: {}
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
   export class ManufactureEditDialogComponent {
     manufacture: Manufacturer;
      city: string;
    contactNumber: number;

    constructor(
      public dialogRef: MatDialogRef<ManufactureEditDialogComponent>,
      @Inject(MAT_DIALOG_DATA) public data: any, private manufactureService: ManufactureService) {}
      onNoClick(): void {
        this.dialogRef.close();
      }

   }
