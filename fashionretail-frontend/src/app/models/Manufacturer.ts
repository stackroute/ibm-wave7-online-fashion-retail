import {ManufacturerOrder} from './ManufacturerOrder';
import {BasePrice} from './BasePrice';

export class Manufacturer {
  id: string;
  name: string;
  email: string;
  city: string;
  specifications: string;
  rating: number;
  contact_number: number;
  manufacturerOrders: ManufacturerOrder[];
  basePrices: BasePrice[];

  constructor(id: string,
              name: string,
              email: string,
              city: string,
              specifications: string,
              rating: number,
              contact_number: number,
              manufacturerOrders: ManufacturerOrder[],
              basePrices: BasePrice[]) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.city = city;
    this.specifications = specifications;
    this.rating = rating;
    this.contact_number = contact_number;
    this.manufacturerOrders = manufacturerOrders;
    this.basePrices = basePrices;
  }
}
