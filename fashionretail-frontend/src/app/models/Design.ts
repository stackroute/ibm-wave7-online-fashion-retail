export class Design {
  id: string;
  name: string;
  design_img: string;
  price: number;
  profitPercent: number;
  discountPercent: number;
  quantityOfDesign: number;
  orderStatus: string;

  constructor(id: string,
              name: string,
              design_img: string,
              price: number,
              profitPercent: number,
              discountPercent: number,
              quantityOfDesign: number,
              orderStatus: string) {
    this.id = id;
    this.name = name;
    this.design_img = design_img;
    this.price = price;
    this.profitPercent = profitPercent;
    this.discountPercent = discountPercent;
    this.quantityOfDesign = quantityOfDesign;
    this.orderStatus = orderStatus;
  }
}


