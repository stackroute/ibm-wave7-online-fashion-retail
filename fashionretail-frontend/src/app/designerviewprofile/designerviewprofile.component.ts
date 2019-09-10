import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Designer } from '../models/Designer';
import { UserService } from '../services/user.service';
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
  constructor(private dialog: MatDialog, private designerService: UserService) { }
  designer: Designer;
  location: string;
  contact: number;


   data;

  ngOnInit() {
    this.designerService.getDesigner().subscribe((data) => {
      this.designer = data;
      console.log(this.designer);
    });
  }


  updateDesigner(designer: Designer) {
    console.log(designer);
    this.designerService.updateDesigner(designer.id, designer).subscribe(
      (data) => {
        console.log('updated Designer ', data);
        this.designerService.getDesigner().subscribe(

          data => { this.designer = data; }

        );

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

