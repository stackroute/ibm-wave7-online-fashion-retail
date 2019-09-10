export class ManufacturerOrder {
  id: string;
  tagId: string;
  designerName: string;
  designImage: string;
  quantityOfDesign: number;
  orderStatus: string;

  constructor(id: string, tagId: string, designerName: string, designImage: string, quantityOfDesign: number, orderStatus: string) {
    this.id = id;
    this.tagId = tagId;
    this.designerName = designerName;
    this.designImage = designImage;
    this.quantityOfDesign = quantityOfDesign;
    this.orderStatus = orderStatus;
  }
}

