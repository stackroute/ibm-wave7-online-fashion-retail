import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ConsumerService } from '../services/consumer.service';
import { Consumer } from '../models/consumer';

@Component({
  selector: 'app-customer-view-profile',
  templateUrl: './customer-view-profile.component.html',
  styleUrls: ['./customer-view-profile.component.css']
})
export class CustomerViewProfileComponent implements OnInit {
  consumer :Consumer=
  {
    id : '',
    userName: '',
    email: '',
     addresses : null,
    consumerOrders :  null,
    cart : null 

  }
  constructor(  private userService: UserService,
    private route : Router, private router : ActivatedRoute,
    private consumerService: ConsumerService) { }

  ngOnInit() {
    console.log(this.userService.loginCredentials);
    this.router.queryParams.subscribe(data => {
       let loginId = data.loginId;
       console.log("in subscribe method id is: ",loginId);
      // this.interComponent.changeId(this.loginId);
      // this.interComponent.currentId.subscribe(data => designer_id = data);
      // this.user = this.designerService.loginCredentials;
      // console.log("id of designer", this.loginId)
      // this.designer.name = this.user.name;
      // this.designer.email = this.user.email;
      // this.designer.userId = this.loginId;

      // console.log("desiger name", this.designer)
      this.consumerService.getConsumerById(loginId).subscribe((data) => {
        console.log("data recieved is: ",data)
        this. consumer= data;
        console.log(this.consumer);
      });
    })
  }

}
