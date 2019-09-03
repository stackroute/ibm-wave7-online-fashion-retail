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
import { Mapping } from '../modals/Mapping';
@Component({
  selector: 'app-designer-home-page',
  templateUrl: './designer-home-page.component.html',
  styleUrls: ['./designer-home-page.component.scss']
})
export class DesignerHomePageComponent implements OnInit {

  upload_designs: DesignerOrder ;
  Mapping: Mapping[];
  manufacturer: Manufacturer[];
  Designer : Designer;
  selectedIndex: number = 0;
  items: Array<any> = [];
  material : Array<Materials> = [];
  savaManufacture : Manufacturer;
  orderlist : Dorder[];
    submitModel : Dorder = {
    id : 0,
    designOrder : {
      id : "string",
      name : "String",
    price : 1,
    discount : 1,
    profit : 1,
    QualityOfDesign : 1,
    OrderStatus : "String",
    dimage : "string",
    },
    manufacturer : {
      id : 1,
      name : "string",
      email : "string",
      city : "string",
      specification : "string",
    },
    designer : {
      id : 0,
      contact: 0,
     name: "",
      location: "",
      email: "",
      rating: 0,
    },
    mapping : [],
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
      this.Mapping = data;
      console.log("materials data", this.Mapping)

    })
    this.userService.getAllManufacture().subscribe((data) => {
      this.manufacturer = data;
      console.log("manufacturer data", this.manufacturer)
    })

    this.userService.getAllOrders().subscribe((data)=>{
      this.orderlist = data;
      console.log("orders list",this.orderlist)
    })
    this.userService.getDesigner().subscribe((data) => {
      this.Designer = data;
      console.log(this.Designer);
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
    // this.material = material;
    this.material.push(material);
    console.log(material);
    // this.nextStep();
    
  }

  previousStep(){
    this.selectedIndex = 0;
  }
  saveManufacture(manufacturer : Manufacturer)
  {
      this.savaManufacture = manufacturer;
      console.log(this.savaManufacture)
     
  }

  submitOrder()
  {
    console.log("designs: ",this.upload_designs);
    console.log("manufacturer: ",this.savaManufacture);
    console.log("material: ",this.material);  
    this.submitModel.designOrder = this.upload_designs;
      this.submitModel.manufacturer = this.savaManufacture;
      this.submitModel.mapping =  this.Mapping
      this.submitModel.designer = this.Designer
      this.userService.submitOrder(this.submitModel).subscribe(
        (data) => {
            console.log(data);
        })
        this.previousStep();
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