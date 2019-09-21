import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../services/authenticate.service';
import { FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginUser } from '../models/LoginUser';
import { Designer } from '../models/Designer';
import { Supplier } from '../models/Supplier';
import { Manufacturer } from '../models/Manufacturer';
import { Consumer } from '../models/consumer';
import { ManufactureService } from '../services/manufacture.service';
import { SupplierService } from '../services/supplier.service';
import { ConsumerService } from '../services/consumer.service';
import { User } from '../models/User';
import { UserService } from '../services/user.service';
// import { from } from 'rxjs';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
 // private user = new LoginUser('','','','');
  private ConfirmNewPassword;
  private user;
  private designer:Designer ;
  private supplier: Supplier;
  private manufacturer:Manufacturer;
  private consumer:Consumer;
  
  constructor(private authenticateService: AuthenticateService,
     private manufactureService:ManufactureService,
     private supplierService:SupplierService,
     private consumerService:ConsumerService,
     private designerService:UserService,
     private formBuilder: FormBuilder, 
     private router: Router,
     private route: ActivatedRoute) { }

  ngOnInit() {
  }


  reset() {
    let email;
    this.route.queryParams.subscribe(params => {
      let id = params["id"];
      console.log(id)
      console.log(params["designation"]);
      if (params["designation"] === 'manufacturer') {
        this.manufactureService.getManufacturerById(id).subscribe(data => {
          email = data.email;
        let user =  new LoginUser('','','','');
          user.username = email;
          user.password = this.ConfirmNewPassword;
          user.designation = params.designation;
          console.log(user);
          this.authenticateService.resetpassword(user)
            .subscribe(data => {
              console.log(data);
            });
        });
      }


      else if (params["designation"] === 'supplier') {
        console.log(params["designation"]);
          this.supplierService.getSupplierById(id).subscribe(data => {
            email = data.email;
            let user = new LoginUser('','','','');
            user.username = email;
            user.password = this.ConfirmNewPassword;
            user.designation = params.designation;
            console.log(user);
            this.authenticateService.resetpassword(user)
              .subscribe(data => {
                console.log(data);
              });
          });
        }

        else if (params["designation"] === 'consumer') {
          console.log(params["designation"]);
            this.consumerService.getConsumerById(id).subscribe(data => {
              email = data.email;
              let user = new LoginUser('','','','');
              user.username = email;
              user.password = this.ConfirmNewPassword;
              user.designation = params.designation;
              console.log(user);
              this.authenticateService.resetpassword(user)
                .subscribe(data => {
                  console.log(data);
                });
            });
          }


          else if (params["designation"] === 'designer') {
            console.log(params["designation"]);
              this.designerService.getDesignerById(id).subscribe(data => {
                email = data.email;
                let user = new LoginUser('','','','');
                user.username = email;
                user.password = this.ConfirmNewPassword;
                user.designation = params.designation;
                console.log(user);
                this.authenticateService.resetpassword(user)
                  .subscribe(data => {
                    console.log(data);
                  });
                });
              }
            })
          }
        }


