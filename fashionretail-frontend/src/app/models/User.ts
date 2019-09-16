export class User {

    userId: string;
    name: string;
    email: string;
    password: string;
    designation: string;

   constructor(userId: string, name: string, email: string, password: string, designation: string) {
       this.userId=userId;
       this.name = name;
       this.email = email;
       this.password = password;
       this.designation = designation;
   }
}
