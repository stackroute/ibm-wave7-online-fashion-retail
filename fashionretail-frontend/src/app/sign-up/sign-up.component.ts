import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
// import { UserServiceService } from '../user-service.service';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {


  user: User = {
    userId: '0',
    name: '',
    password : '',
    email : '',
    designation: '',
  };
  registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) { }

  ngOnInit() {
   this.registerForm = this.formBuilder.group({
     name : [this.user.name, [
       Validators.required]
     ],
     email: [this.user.email, [Validators.required, Validators.email]],
     password : [this.user.password, [Validators.required, Validators.minLength(8), Validators.maxLength(15)]],
     designation: [this.user.designation, [Validators.required]]
    });
    }
    onRegisterSubmit(user: User) {
      console.log('inside register');
      const num = Math.floor(Math.random() * (999999 - 100000)) + 100000;
      console.log('random number is ', 'num');
      user.userId = '' + num;
      // alert(this.user.name + ' ' + this.user.email + ' ' + this.user.password);
      this.userService.saveUser(user).subscribe((data) => {
        this.user = data;
        console.log(this.user);
        this.router.navigateByUrl('login');
      });
    }
  }


