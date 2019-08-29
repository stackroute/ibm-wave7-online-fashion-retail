import { Component, OnInit ,Inject} from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { User } from '../modals/User';
import { Designer } from '../modals/Designer';
import { UserServiceService } from '../user-service.service';
import { MatTabChangeEvent } from '@angular/material';
@Component({
  selector: 'app-designer-home-page',
  templateUrl: './designer-home-page.component.html',
  styleUrls: ['./designer-home-page.component.scss']
})
export class DesignerHomePageComponent implements OnInit {

  upload_designs: Designer;
  Material: User[];
  getData: User[];
  selectedIndex : number=0;
  items: Array<any> = [];
  constructor(private dialogue: MatDialog, private userService: UserServiceService) { 
    this.items=[
      { name: 'assets/designer.jpg'},
      // {name: 'assets/img/designer3.jpg'},
      
      // { name: 'assets/img/designer2.jpeg'},
      // // {name: 'assets/img/designer1.jpg'},
      // { name: 'assets/img/facebook.png'},
      // { name: 'assets/img/gmail.png'},

    ];
  }

  ngOnInit() {
    this.userService.getAllUsers().subscribe((data)=>{
      this.getData=data;
      console.log("users data",this.getData)

  })
  }

  openDialog() {
    const dialogRef = this.dialogue.open(UploadDesignsDialogue,
      {
        width: '350px',
        data: {}
      });

    dialogRef.afterClosed().subscribe(result => {
      if (result != undefined) {
          this.saveDesigns(result);
          this.nextStep();
        console.log(result);
        this.upload_designs=result;
      }
    });
  }
  saveDesigns(designer : Designer){
    this.userService.saveDesigns(designer).subscribe((data) =>{
      this.upload_designs=data;
      console.log("result ",this.upload_designs)
    })
  } 

  getAllUser(){
    alert("entered into get all users")
    this.userService.getAllUsers().subscribe((data)=>{
        this.Material=data;
        console.log("users data",this.Material)

    })
  }

  public tabChanged(tabChangeEvent: MatTabChangeEvent): void {
    this.selectedIndex = tabChangeEvent.index;
}

public nextStep() {
    this.selectedIndex += 1;
}

}



@Component({
  selector: 'upload-designs-dialogue',
  templateUrl: 'upload-designs-dialogue.html',
})

export class UploadDesignsDialogue {

  constructor(
    public dialogRef: MatDialogRef<UploadDesignsDialogue>,
    @Inject(MAT_DIALOG_DATA) public data: Designer) { }

  onNoClick(): void {
    this.dialogRef.close();
  }
}


