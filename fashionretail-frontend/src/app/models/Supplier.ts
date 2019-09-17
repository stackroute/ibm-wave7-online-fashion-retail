import {SupplierOrder} from './SupplierOrder';

export class Supplier {
  id: string;
  name: string;
  city: string;
  rating: string;
  email: string;
  contactNumber: string;
  supplierOrders: SupplierOrder[];

  constructor(id: string,
              name: string,
              city: string,
              rating: string,
              email: string) {
    this.id = id;
    this.name = name;
    this.city = city;
    this.rating = rating;
    this.email = email;
  }
}
