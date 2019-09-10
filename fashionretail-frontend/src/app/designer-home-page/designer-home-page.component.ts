import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { User } from '../modals/User';
import { Designer } from '../modals/Designer';
import { UserServiceService } from '../services/user-service.service';
import { MatTabChangeEvent } from '@angular/material';
import { Materials } from '../modals/Materials';
import { Manufacturer } from '../modals/Manufacturer';
import { Mapping } from '../modals/Mapping';
import { Design } from '../modals/Design';
import { DesignerOrder } from '../modals/DesignerOrder';
import { ManufacturerOrder } from '../modals/ManufacturerOrder';
import { BasePrice } from '../modals/BasePrice';
@Component({
  selector: 'app-designer-home-page',
  templateUrl: './designer-home-page.component.html',
  styleUrls: ['./designer-home-page.component.scss']
})
export class DesignerHomePageComponent implements OnInit {

  upload_designs: Design ;
  upload_designs1 : Design[];
  manufacturer: Manufacturer[];
  Designer : Designer;
  selectedIndex: number = 0;
  items: Array<any> = [];
  // material : Array<Materials> = [];

  savaManufacture : Manufacturer;
  orderlist : DesignerOrder[];
  orderDetails : DesignerOrder;

  manufacturerOrder : Array<ManufacturerOrder>= [];
  basePricess : Array<BasePrice> = [];
  mapping : Mapping[];
  supplierMaterialList : Array<Map<string,number>> ; 
  updatedOrder : DesignerOrder = {
    id : "",
    tagId : "",
    design: {
      id : "",
      name : "",
      price : 0,
      discountPercentage : 0,
      profitPercentage : 0,
      QuantityOfDesign : 0,
      OrderStatus : "",
      design_img : "",
    },
    manufacturer : {
      id : 0,
    name : "",
    email : "",
    contact_number: 0, 
    specifications: "",
    city: "",
    rating: 0,
    basePrice : this.basePricess,
    manufacturerOrder : this.manufacturerOrder
    },
   
    supplierList : this.supplierMaterialList = [],
    };

  material: Mapping[] =[];
  MaterialQuantity : number;


  private quantityMap :Map<string, number> = new Map([]);
    // orderdetails : 

  constructor(private dialogue: MatDialog, private userService: UserServiceService) {
    this.items = [
      { name: 'assets/designer.jpg' },
    ];
  }

  ngOnInit() {
    this.userService.getAllMaterial().subscribe((data) => {
      this.mapping = data;
      console.log("materials data", this.mapping)

    })
    this.userService.getAllManufacture().subscribe((data) => {
      this.manufacturer = data;
      console.log("manufacturer data", this.manufacturer)
    })

    this.getAllorders();

    this.userService.getDesigner().subscribe((data) => {
      this.Designer = data;
      console.log(this.Designer);
    })
  }
  Mapping(arg0: string, Mapping: any) {
    throw new Error("Method not implemented.");
  }

  getAllorders()
  {
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
  saveDesigns(design : Design) {
  }

  saveMaterial(mapping: Mapping) {
    console.log(mapping);
    this.material.push(mapping);
    this.quantityMap.set(mapping.id, mapping.materialQuantity);
    this.updatedOrder.design = this.upload_designs;
    this.updatedOrder.supplierList.push(this.quantityMap);
    console.log(this.updatedOrder);
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
    console.log("material: ",this.supplierMaterialList);
      this.updatedOrder.design = this.upload_designs;
      this.updatedOrder.manufacturer = this.savaManufacture;
      console.log("updated order",this.updatedOrder);
      let num=Math.floor(Math.random() * (999999 - 100000)) + 100000;
       console.log("random number is ",num);
       this.updatedOrder.id=""+num;
      this.userService.submitOrder(this.updatedOrder).subscribe(
        (data) => {
          this.orderDetails = data
            console.log( "orderlist",this.orderDetails);
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

  previousStep(){
    this.selectedIndex = 0;
  }

  openDialogPrice(dorderData : DesignerOrder) {
    const dialogRef = this.dialogue.open(AddPriceDialogue,
      {
        width: '350px',
        data: dorderData
      });
        
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
    //   if (result != undefined) {
    //     this.userService.updateOrder(result,result.id).subscribe((data) => {
    //       this.getAllorders();
    //     })
    //   }
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
    @Inject(MAT_DIALOG_DATA) public data: DesignerOrder[]) { }

    ngOnInit()
    {
      console.log(this.data);
    }

  onNoClick(): void {
    this.dialogRef.close();
  }
}