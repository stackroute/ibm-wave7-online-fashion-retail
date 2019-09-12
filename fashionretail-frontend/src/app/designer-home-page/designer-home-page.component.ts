import {Component, OnInit, Inject} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {User} from '../models/User';
import {Designer} from '../models/Designer';
import {UserService} from '../services/user.service';
import {MatTabChangeEvent} from '@angular/material';
import {Material} from '../models/Material';
import {Manufacturer} from '../models/Manufacturer';
import {Mapping} from '../models/Mapping';
import {Design} from '../models/Design';
import {DesignerOrder} from '../models/DesignerOrder';
import {ManufacturerOrder} from '../models/ManufacturerOrder';
import {BasePrice} from '../models/BasePrice';


@Component({
  selector: 'app-designer-home-page',
  templateUrl: './designer-home-page.component.html',
  styleUrls: ['./designer-home-page.component.scss']
})
export class DesignerHomePageComponent implements OnInit {

  uploadDesigns: Design;
  uploadDesigns1: Design[];
  manufacturer: Manufacturer[];
  Designer: Designer;
  selectedIndex = 0;
  items: Array<any> = [];
  // material : Array<Materials> = [];

  savaManufacture: Manufacturer;
  orderlist: DesignerOrder[];
  orderDetails: DesignerOrder;

  manufacturerOrder: Array<ManufacturerOrder> = [];
  basePricess: Array<BasePrice> = [];
  mapping: Mapping[];
  supplierMaterialList: Array<Map<string, number>>;
  updatedOrder: DesignerOrder = {
    id: '',
    tagId: '',
    designOrder: {
      id: '',
      name: '',
      price: 0,
      discountPercent: 0,
      profitPercent: 0,
      quantityOfDesign: 0,
      orderStatus: '',
      design_img: '',
    },
    manufacturer: {
      id: '0',
      name: '',
      email: '',
      contact_number: 0,
      specifications: '',
      city: '',
      rating: 0,
      basePrices: this.basePricess,
      manufacturerOrders: this.manufacturerOrder
    },

    supplierList: this.supplierMaterialList = [],
  };

  material: Mapping[] = [];
  MaterialQuantity: number;


  private quantityMap: Map<string, number> = new Map([]);

  // orderdetails :

  constructor(private dialogue: MatDialog, private userService: UserService) {
    this.items = [
      {name: 'assets/designer.jpg'},
    ];
  }

  ngOnInit() {

    this.userService.getAllMaterial().subscribe((data) => {
      this.mapping = data;
      console.log('materials data', this.mapping);

    });
    this.userService.getAllManufacture().subscribe((data) => {
      this.manufacturer = data;
      console.log('manufacturer data', this.manufacturer);
    });

    this.getAllorders();

    this.userService.getDesignerById('1').subscribe((data) => {
      // this.Designer = data;
      console.log(data);
    });
  }

  Mapping(arg0: string, mapping: any) {
    throw new Error('Method not implemented.');
  }

  getAllorders() {
    this.userService.getAllOrders().subscribe((data) => {
      this.orderlist = data;
      console.log('orders list', this.orderlist);
    });
  }

  openDialog() {
    const dialogRef = this.dialogue.open(UploadDesignsDialogueComponent,
      {
        width: '350px',
        data: {}
      });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.saveDesigns(result);
        this.nextStep();
        console.log(result);
        this.uploadDesigns = result;
      }
    });
  }

  saveDesigns(design: Design) {
  }

  saveMaterial(mapping: Mapping) {
    console.log(mapping);
    this.material.push(mapping);
    this.quantityMap.set(mapping.id, mapping.quantity);
    this.updatedOrder.designOrder = this.uploadDesigns;
    this.updatedOrder.supplierList.push(this.quantityMap);
    console.log(this.updatedOrder);
  }


  saveManufacture(manufacturer: Manufacturer) {
    this.savaManufacture = manufacturer;
    console.log(this.savaManufacture);

  }

  submitOrder() {
    console.log('designs: ', this.uploadDesigns);
    console.log('manufacturer: ', this.savaManufacture);
    console.log('material: ', this.supplierMaterialList);
    this.updatedOrder.designOrder = this.uploadDesigns;
    this.updatedOrder.manufacturer = this.savaManufacture;
    console.log('updated order', this.updatedOrder);
    const num = Math.floor(Math.random() * (999999 - 100000)) + 100000;
    console.log('random number is ', num);
    this.updatedOrder.id = '' + num;
    this.userService.submitOrder(this.updatedOrder).subscribe(
      (data) => {
        this.orderDetails = data;
        console.log('orderlist', this.orderDetails);
      });
    this.previousStep();
  }

  getAllUser() {
    alert('entered into get all users');
    this.userService.getAllUsers().subscribe((data) => {
    });
  }

  public tabChanged(tabChangeEvent: MatTabChangeEvent): void {
    this.selectedIndex = tabChangeEvent.index;
  }

  public nextStep() {
    this.selectedIndex += 1;
  }

  previousStep() {
    this.selectedIndex = 0;
  }

  openDialogPrice(dorderData: DesignerOrder) {
    const dialogRef = this.dialogue.open(AddPriceDialogueComponent,
      {
        width: '350px',
        // data: dorderData
        data: this.orderlist
      });

    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      if (result != undefined) {
        // this.userService.updateOrder(result,result.id).subscribe((data) => {
        //   this.getAllorders();
        // })
      }
    });
  }
}

@Component({
  selector: 'upload-designs-dialogue',
  templateUrl: 'upload-designs-dialogue.html',
})

export class UploadDesignsDialogueComponent {

  constructor(
    public dialogRef: MatDialogRef<UploadDesignsDialogueComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DesignerOrder) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }


}

@Component({
  selector: 'AddPrice-dialogue',
  templateUrl: 'AddPriceDialogue.html',
})

export class AddPriceDialogueComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<AddPriceDialogueComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DesignerOrder[]) {
  }

  ngOnInit() {
    console.log(this.data);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
