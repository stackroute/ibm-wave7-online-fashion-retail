import {Supplier} from './Supplier';
import {Material} from './Material';

export class Mapping {
  id: string;
  price: number;
  quantity: number;
  material: Material;
  supplier: Supplier;
  unit: string;

  constructor(id: string, price: number, quantity: number, material: Material, supplier: Supplier, unit: string) {
    this.id = id;
    this.price = price;
    this.quantity = quantity;
    this.material = material;
    this.supplier = supplier;
    this.unit = unit;
  }
}
