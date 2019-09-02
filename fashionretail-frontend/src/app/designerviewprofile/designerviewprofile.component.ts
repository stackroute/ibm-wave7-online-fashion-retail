import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {Designer} from '../modals/Designer'
import { Router } from '@angular/router';

@Component({
  selector: 'app-designerviewprofile',
  templateUrl: './designerviewprofile.component.html',
  styleUrls: ['./designerviewprofile.component.css']
})
export class DesignerviewprofileComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit() {
  }
  // openDialog(designer:Designer) {
  //   const dialogRef = this.dialog.open(designerEditDialogue,
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
edit()
{
  this.route.navigateByUrl("designerEdit");
}
}
