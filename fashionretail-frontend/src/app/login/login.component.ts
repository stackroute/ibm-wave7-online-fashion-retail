import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginUser } from '../models/LoginUser';
import { AuthenticateService } from '../services/authenticate.service';
import { LoginService } from '../services/login.service';
import { UserService } from '../services/user.service';
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
              private loginService: LoginService,
              private userService: UserService) { }
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

        // this.loginService.getByName(this.user.username).subscribe((data)=>{
        //   this.user = data
        //   console.log(this.user)
        // })
        console.log('designer data', data);
        this.userService.loginCredentials = data
        const id = data.userId;
        if (data.designation === 'Supplier') {
          this.router.navigate(['/suppliers'], {queryParams : {id}});
        } else if (data.designation === 'Designer') {
          this.router.navigate(['/designer'], {queryParams : {id}});
        } else if(data.designation == 'Manufacturer'){
          this.router.navigate(['/manufacturer'], {queryParams : {id}});
        }
        else{
          this.router.navigate(['/consumer']), {queryParams : {id}}
        }
      },
      error => {
        
        console.log(error);
        alert("Invalid UserName and password");
      });
  }
  logout() {
    this.router.navigate(['/LogOut']);
  }
}
