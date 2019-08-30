import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { User } from '../modals/User';
import { UserServiceService } from '../user-service.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public user : User;
  constructor(private dialog: MatDialog, private userService : UserServiceService) { }
  

  ngOnInit() {
  }

  openDialog() {
    const dialogRef = this.dialog.open(SignUpDialogue,
      {
        width: '350px',
        data: {}
      });

    dialogRef.afterClosed().subscribe(result => {
      if (result != undefined) {
         this.saveUser(result);
        console.log(result);
      }
    });
  }
  
  saveUser(user : User){
    let num=Math.floor(Math.random() * (999999 - 100000)) + 100000;
        console.log("random number is ",num);
        user.id=num;
      this.userService.saveUser(user).subscribe((data) =>{
        this.user=data;
        console.log("result ",this.user)
      })
    }
  }
  
  
  
  @Component({
    selector: 'signUp-dialogue',
    templateUrl: 'signUp-dialogue.html',
  })
  
  export class SignUpDialogue {
  
    constructor(
  
      public dialogRef: MatDialogRef<SignUpDialogue>,
      @Inject(MAT_DIALOG_DATA) public data: User) { }
  
    onNoClick(): void {
      this.dialogRef.close();
    }
  }
  
 

