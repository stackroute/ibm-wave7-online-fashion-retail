import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Designer } from '../models/Designer';
import { UserService } from '../services/user.service';
import { AuthenticateService } from '../services/authenticate.service';
import { User } from '../models/User';
export interface DialogData {
  location: string;
  contact: number;
}

@Component({
  selector: 'app-designerviewprofile',
  templateUrl: './designerviewprofile.component.html',
  styleUrls: ['./designerviewprofile.component.css']
})
export class DesignerviewprofileComponent implements OnInit {
  constructor(private dialog: MatDialog, 
    private designerService: UserService,private authentication : AuthenticateService) { }
  designer: Designer;
  location: string;
  contact: number;
  user : User


   data;

  ngOnInit() {
    console.log(this.designerService.loginCredentials);
    this.user = this.designerService.loginCredentials;
    // this.designerService.getDesignerById(loginUserId).subscribe((data) => {
    //   console.log(data)
    //   this.user = data;
    //   console.log(this.designer);
      
    // });
  }


  updateDesigner(designer: Designer) {
    console.log(designer);
    this.designerService.updateDesigner(designer.id, designer).subscribe(
      (data) => {
        console.log('updated Designer ', data);
        // this.designerService.getDesignerById("id").subscribe(

          // data => { this.designer = data; }

        // );

      }
    );
  }
  openDialog() {
    const dialogRef = this.dialog.open(designerEditDialogue,
      {
        width: '250px',
        // data : {location: this.location, contact: this.contact}
        data: {}
      });
    dialogRef.afterClosed().subscribe(result => {
      // if(result!= undefined){
      this.data = result;
      console.log(result);
      this.updateDesigner(result);
      // }
    });
  }

}
@Component({
  selector: 'app-designerEditDialogue',
  templateUrl: 'designerEditDialogue.html',
})
export class designerEditDialogue {
  designer: Designer;
  location: string;
  contact: number;
  constructor(
    public dialogRef: MatDialogRef<designerEditDialogue>,
    @Inject(MAT_DIALOG_DATA) public data: Designer) { }
  onNoClick(): void {
    this.dialogRef.close();
    console.log('end og dialog');
  }

}

