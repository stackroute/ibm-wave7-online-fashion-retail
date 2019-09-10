import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../services/authenticate.service';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginUser } from '../models/LoginUser';
// import { from } from 'rxjs';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
  private newPassword: string;
  private ConfirmNewPassword;

  constructor(private authenticateService: AuthenticateService, private formBuilder: FormBuilder, private router: Router) { }
login = new LoginUser('', '', '');
  ngOnInit() {
  }
  reset() {
    // console.log(this.ConfirmNewPassword);
    // this.authenticateService.resetpassword(this.ConfirmNewPassword)
    // console.log("srija")
    console.log('hello');
    this.login.username = 'srijak890@gmail.com';
    this.login.password = this.ConfirmNewPassword;
    console.log(this.ConfirmNewPassword);
    this.authenticateService.resetpassword(this.login)
    .subscribe(data => {
      console.log(data);
    });
}

}
