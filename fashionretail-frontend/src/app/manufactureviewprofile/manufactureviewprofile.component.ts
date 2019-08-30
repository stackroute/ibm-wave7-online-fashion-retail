import { Component, OnInit, Inject } from '@angular/core';
import { Manufacture } from '../modals/Manufacture';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { ManufactureregistrationService } from '../manufactureregistration.service';

@Component({
  selector: 'app-manufactureviewprofile',
  templateUrl: './manufactureviewprofile.component.html',
  styleUrls: ['./manufactureviewprofile.component.css']
})
export class ManufactureviewprofileComponent implements OnInit {
  manufacture: Manufacture
  public updatedEmail:String
  public updateManufacture: Manufacture

  constructor(){}
  // constructor(private registrationService: ManufactureregistrationService, private dialog: MatDialog) { }

  ngOnInit() {
  }
}
  // openDialog(manufacture:Manufacture) {
    
  //   const dialogRef = this.dialog.open(DialogComponent,
  //     {
  //       width : '250px',
  //       data : {}
  //     });
  //     dialogRef.afterClosed().subscribe(result => {
  //       this.updatedEmail = result;
  //       console.log('Dialog result: ${result}');
  //       console.log('updated comment:' , this.updatedEmail);
  //       this.updateManufacture;
  //     });
  //   }

  // //   onclick(){
  // //     //console.log(user);
  // //     this.registrationService.updateUser(this.updateManufacture.email,this.updateManufacture).subscribe((data)=> {
  // //        this.manufacture = data;
  // //       console.log("result is ", data);
  // //     });
  // // }
  // // saveManufacture(manufacture:Manufacture) {
  // //   console.log(manufacture);
  // //   this.registrationService.saveManufacture(manufacture).subscribe((data)=> {
  // //      this.manufacture = data;
  // //     console.log("result is ", manufacture);
  // //   });
  // // }
  
  // }

  // @Component({
  //   selector: 'app-dialogComponent',
  //   templateUrl: 'dialogComponent.html',
  //  })
  //  export class DialogComponent {
  //   constructor(
  //     public dialogRef: MatDialogRef<DialogComponent>,
  //     @Inject(MAT_DIALOG_DATA) public data: Manufacture) {}
  //     onNoClick(): void {
  //       this.dialogRef.close();
  //     }
  //  }
