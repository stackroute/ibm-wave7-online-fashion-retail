import {DesignerOrder} from './DesignerOrder';

export class Designer {
  userId: string;
  name: string;
  city: string;
  rating: number;
  email: string;
  contactNumber: number;
  orderList: DesignerOrder[];

  constructor(userId: string, name: string, city: string, rating: number, email: string, contactNumber: number, orderList: DesignerOrder[]) {
    this.userId = userId;
    this.name = name;
    this.city = city;
    this.rating = rating;
    this.email = email;
    this.contactNumber = contactNumber;
    this.orderList = orderList;
  }
}

