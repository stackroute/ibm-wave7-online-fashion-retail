import {DesignerOrder} from './DesignerOrder';

export class Designer {
  id: string;
  name: string;
  city: string;
  rating: number;
  email: string;
  contactNumber: number;
  orderList: DesignerOrder[];

  constructor(id: string, name: string, city: string, rating: number, email: string, contactNumber: number, orderList: DesignerOrder[]) {
    this.id = id;
    this.name = name;
    this.city = city;
    this.rating = rating;
    this.email = email;
    this.contactNumber = contactNumber;
    this.orderList = orderList;
  }
}

