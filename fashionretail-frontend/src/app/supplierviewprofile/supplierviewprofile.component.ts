import { Component, OnInit, Inject} from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Supplier } from '../models/Supplier';
import { SupplierService } from '../services/supplier.service';
import { UserService } from '../services/user.service';
import { User } from '../models/User';

export interface DialogData {
  city: string;
  contactNumber: number;
}

@Component({
  selector: 'app-supplierviewprofile',
  templateUrl: './supplierviewprofile.component.html',
  styleUrls: ['./supplierviewprofile.component.css']
})
export class SupplierviewprofileComponent implements OnInit {

  constructor(private dialog: MatDialog, private supplierService: SupplierService,private userService: UserService ) { }

 supplier: Supplier;
 city: string;
 contactNumber: number;
  user: User;
  data;


  ngOnInit() {
    this.user = this.userService.loginCredentials;
  this.supplierService.getSupplier().subscribe((data) => {
  this.supplier = data;
  console.log(this.supplier);
  });
  }

   updateSupplier(supplier: Supplier) {
      console.log(supplier);
      this.supplierService.updateSupplier( supplier, supplier.id).subscribe((data) => {
      console.log('result is', data);
      this.supplierService.getSupplier().subscribe((data) => {this.supplier = data; });
      });
      }
openDialog(supplier: Supplier) {
    const dialogRef = this.dialog.open(SupplierEditDialogue,
      {
        width: '350px',
        data: {}
      });

    dialogRef.afterClosed().subscribe(result => {
    this.data = result;
    console.log(result);
    this.updateSupplier(result);
    });
  }
}


@Component({
    selector: 'supplierEdit-dialogue',
    templateUrl: 'supplierEdit-dialogue.html',
  })

  export class SupplierEditDialogue {

  supplier: Supplier;
  city: string;
  contactNumber: number;

    constructor(

      public dialogRef: MatDialogRef<SupplierEditDialogue>,
      @Inject(MAT_DIALOG_DATA) public data: Supplier, private supplierService: SupplierService) { }

    onNoClick(): void {
      this.dialogRef.close();
    }

  }
