import {Component, OnInit} from '@angular/core';
import {User} from '../models/User';
import {FormGroup, FormBuilder, Validators, AbstractControl, ValidatorFn} from '@angular/forms';
// import { UserServiceService } from '../user-service.service';
import {Router} from '@angular/router';
import {UserService} from '../services/user.service';
import {UniqueEmailValidator} from './unique-email-validator';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {


  validEmail = true;
  emailPlaceholderValue = 'Enter your email';
  user: User = {
    id: '0',
    name: '',
    password: '',
    email: '',
    designation: '',
  };
  registerForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private userService: UserService,
              private router: Router,
              private uniqueEmailValidator: UniqueEmailValidator) {
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      name: [this.user.name, [
        Validators.required]
      ],
      email: [this.user.email, {
        syncValidators: [Validators.required, Validators.email],
        asyncValidators: [this.uniqueEmailValidator.validate.bind(this.uniqueEmailValidator)],
        updateOn: 'blur'
      }],
      password: [this.user.password, [Validators.required, Validators.minLength(6), Validators.maxLength(15)]],
      designation: [this.user.designation, [Validators.required]]
    });
  }

  onRegisterSubmit(user: User) {
    console.log('inside register');
    // const num = Math.floor(Math.random() * (999999 - 100000)) + 100000;
    console.log('random number is ', 'num');
    // user.id = '' + num;
    // alert(this.user.name + ' ' + this.user.email + ' ' + this.user.password);
    this.userService.saveUser(user).subscribe((data) => {
      this.user = data;
      console.log(this.user);
      this.router.navigateByUrl('login');
      },
    );
  }
  get email() { return this.registerForm.get('email'); }
}


