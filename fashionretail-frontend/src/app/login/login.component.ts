import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginUser } from '../models/LoginUser';
import { AuthenticateService } from '../services/authenticate.service';
import { LoginService } from '../services/login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public result;
  private user = new LoginUser('', '', '');
  loginForm: FormGroup;

  constructor(private authenticateService: AuthenticateService,
              private formBuilder: FormBuilder,
              private router: Router,
              private loginService: LoginService) { }
  ngOnInit() {
        // this.authenticateService.login(this.user)
    // .subscribe(data=>this.result=data);
    this.createForm();
  }

  createForm() {
    this.loginForm = this.formBuilder.group({
      username: [''],
      password: ['']
    });
  }

  loginUser() {
    this.user.username = this.loginForm.get('username').value;
    this.user.password = this.loginForm.get('password').value;
    console.log(this.user);
    this.authenticateService.login(this.user)
      .subscribe(data => {

        this.loginService.getByName(this.user.username).subscribe((data) => {
          this.user = data;
          console.log(this.user);
        });
        const id = data.id;
        if (data.designation === 'Supplier') {
          this.router.navigate(['/supplier'], {queryParams : {id}});
        } else if (data.designation === 'designer') {
          this.router.navigate(['/designer'], {queryParams : {id}});
        } else {
          this.router.navigate(['/manufacturer'], {queryParams : {id}});
        }
      },
      error => {
        console.log(error);
      });
  }
  logout() {
    this.router.navigate(['/LogOut']);
  }
}
