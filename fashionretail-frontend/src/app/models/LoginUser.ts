import { stringToKeyValue } from '@angular/flex-layout/extended/typings/style/style-transforms';

export class LoginUser {
  username: string;
  password: string;
  designation:string;
  email: string;

  constructor(username: string, password: string, designation:string,email: string) {
    this.username = username;
    this.password = password;
    this.designation=designation;
    this.email = email;
  }
}
