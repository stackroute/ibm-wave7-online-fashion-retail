import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { User } from '../modals/User';
import { Designer } from '../modals/Designer';
import { UserServiceService } from '../user-service.service';
import { MatTabChangeEvent } from '@angular/material';
import { Materials } from '../modals/Materials';
import { DesignerOrder } from '../modals/DesignerOrder';
import { Manufacturer } from '../modals/Manufacturer';
import { Manufacture } from '../modals/Manufacture';
import { Dorder } from '../modals/Dorder';
@Component({
  selector: 'app-designer-home-page',
  templateUrl: './designer-home-page.component.html',
  styleUrls: ['./designer-home-page.component.scss']
})
export class DesignerHomePageComponent implements OnInit {

  upload_designs: DesignerOrder;
  Materials: Materials[];
  manufacturer: Manufacturer[];
  selectedIndex: number = 0;
  items: Array<any> = [];
  material : Materials;
  savaManufacture : Manufacturer;
  orderlist : Dorder[];
    submitModel : Dorder = {
    id : 0,
    designOrder : {
      id : 0,
      name : "String",
    price : 1,
    discount : 1,
    profit : 1,
    QualityOfDesign : 1,
    OrderStatus : "String",
    },
    manufacturer : {
      id : 1,
      name : "string",
      email : "string",
      city : "string",
      specification : "string",
    },
    material : {
      name : "string",
    M_image : "string",
    categiry : "string",
    quantity : "string",
    }
  };

  constructor(private dialogue: MatDialog, private userService: UserServiceService) {
    this.items = [
      { name: 'assets/designer.jpg' },
      // {name: 'assets/img/designer3.jpg'},

      // { name: 'assets/img/designer2.jpeg'},
      // // {name: 'assets/img/designer1.jpg'},
      // { name: 'assets/img/facebook.png'},
      // { name: 'assets/img/gmail.png'},

    ];
  }

  ngOnInit() {
    this.userService.getAllMaterial().subscribe((data) => {
      this.Materials = data;
      console.log("materials data", this.Materials)

    })
    this.userService.getAllManufacture().subscribe((data) => {
      this.manufacturer = data;
      console.log("manufacturer data", this.manufacturer)
    })

    this.userService.getAllOrders().subscribe((data)=>{
      this.orderlist = data;
      console.log("orders list",this.orderlist)
    })
  }

  openDialog() {
    const dialogRef = this.dialogue.open(UploadDesignsDialogue,
      {
        width: '350px',
        data: {}
      });

    dialogRef.afterClosed().subscribe(result => {
      if (result != undefined) {
        this.saveDesigns(result);
        this.nextStep();
        console.log(result);
        this.upload_designs = result;
      }
    });
  }
  saveDesigns(designer: Designer) {

    // this.userService.saveDesigns(designer).subscribe((data) =>{
    //   this.upload_designs=data;
    //   console.log("result ",this.upload_designs)
    // })
  }

  saveMaterial(material: Materials) {
    this.material = material;
    console.log(material);
    this.nextStep();
  }

  saveManufacture(manufacturer : Manufacturer)
  {
      this.savaManufacture = manufacturer;
  }

  submitOrder()
  {
      this.submitModel.designOrder = this.upload_designs;
      this.submitModel.manufacturer = this.savaManufacture;
      this.submitModel.material =  this.material
      this.userService.submitOrder(this.submitModel).subscribe(
        (data) => {
            console.log(data);
        })
  }

  getAllUser() {
    alert("entered into get all users")
    this.userService.getAllUsers().subscribe((data) => {
      // this.Material=data;
      // console.log("users data",this.Material)

    })
  }
  // getAllMaterial(){
  //   alert("entered into get all users")
  //   this.userService.getAllMaterial().subscribe((data)=>{
  //       this.Materials=data;
  //       console.log("users data",this.Material)

  //   })
  // }

  public tabChanged(tabChangeEvent: MatTabChangeEvent): void {
    this.selectedIndex = tabChangeEvent.index;
  }

  public nextStep() {
    this.selectedIndex += 1;
  }

}



@Component({
  selector: 'upload-designs-dialogue',
  templateUrl: 'upload-designs-dialogue.html',
})

export class UploadDesignsDialogue {

  constructor(
    public dialogRef: MatDialogRef<UploadDesignsDialogue>,
    @Inject(MAT_DIALOG_DATA) public data: DesignerOrder) { }

  onNoClick(): void {
    this.dialogRef.close();
  }
}