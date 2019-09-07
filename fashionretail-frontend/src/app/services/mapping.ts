import { Material } from './material';
import { Supplier } from './supplier';

export class Mapping {
    id: number;
    quantity: string;
    price:number;
    material: Material;
    supplier: Supplier;

    constructor(id: number,quantity:string,price:number,material: Material,supplier: Supplier)
{
    this.id=id;
    this.quantity=quantity;
    this.price=price;
    this.material=material;
    this.supplier=supplier;
}

}
