import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { User } from '../modals/User';
import { Designer } from '../modals/Designer';
import { UserServiceService } from '../services/user-service.service';
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
  upload_designs1 : DesignerOrder[];
  Mapping: Mapping[];
  manufacturer: Manufacturer[];
  Designer : Designer;
  selectedIndex: number = 0;
  items: Array<any> = [];
  material : Array<Materials> = [];
  savaManufacture : Manufacturer;
  orderlist : Dorder[];
  orderDetails : Dorder;
    submitModel : Dorder = {
    id : "",
    designOrder : {
      id : "string",
      name : "String",
    price : 1,
    discount : 1,
    profit : 1,
    QuantityOfDesign : 1,
    OrderStatus : "String",
    design_img : "string",
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
    // orderdetails : 

  constructor(private dialogue: MatDialog, private userService: UserServiceService) {
    this.items = [
      { name: 'assets/designer.jpg' },
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
  }

  saveMaterial(material: Materials) {
    this.material.push(material);
    console.log(material);

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
          this.orderDetails = data
            console.log(data);
        })
        this.previousStep();
  }
  getAllUser() {
    alert("entered into get all users")
    this.userService.getAllUsers().subscribe((data) => {
    })
  }
  public tabChanged(tabChangeEvent: MatTabChangeEvent): void {
    this.selectedIndex = tabChangeEvent.index;
  }
  public nextStep() {
    this.selectedIndex += 1;
  }

  openDialogPrice(id : DesignerOrder) {
    const dialogRef = this.dialogue.open(AddPriceDialogue,
      {
        width: '350px',
        data: this.orderlist
      });
        
    dialogRef.afterClosed().subscribe(result => {
      if (result != undefined) {
        this.saveDesigns(result);
        // this.nextStep();
        console.log(result);
        this.upload_designs = result;
      }
    });
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

@Component({
  selector: 'AddPrice-dialogue',
  templateUrl: 'AddPriceDialogue.html',
})

export class AddPriceDialogue {

  constructor(
    public dialogRef: MatDialogRef<AddPriceDialogue>,
    @Inject(MAT_DIALOG_DATA) public data: Dorder[]) { }

    ngOnInit()
    {
      console.log(this.data);
    }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
