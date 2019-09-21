import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../services/authenticate.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { LoginUser } from '../models/LoginUser';
@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})


export class ForgotpasswordComponent implements OnInit {
  private user = new LoginUser('','','','');
  private emailid;
  constructor(private authenticateService: AuthenticateService,
              private formBuilder: FormBuilder,
              private router: Router,
              private http: HttpClient) { }

  ngOnInit() {
  }

  reset() {
    console.log(this.emailid);
    this.user.username = this.emailid;
    this.authenticateService.forgotpassword(this.user)
    .subscribe(data => {
      console.log(data);
    });

  }
}

