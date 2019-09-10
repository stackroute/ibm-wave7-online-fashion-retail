import {Material} from './Material';

export class SupplierOrder {
  id: string;
  designerName: string;
  material: Material;
  quantity: number;
  orderStatus: string;
  tagId: string;


  constructor(id: string, designerName: string, material: Material, quantity: number, orderStatus: string, tagId: string) {
    this.id = id;
    this.designerName = designerName;
    this.material = material;
    this.quantity = quantity;
    this.orderStatus = orderStatus;
    this.tagId = tagId;
  }
}
