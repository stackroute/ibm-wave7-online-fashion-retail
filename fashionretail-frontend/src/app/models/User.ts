export class User {

    id: string;
    name: string;
    email: string;
    password: string;
    designation: string;

   constructor(id: string, name: string, email: string, password: string, designation: string) {
       this.id = id;
       this.name = name;
       this.email = email;
       this.password = password;
       this.designation = designation;
   }
}
