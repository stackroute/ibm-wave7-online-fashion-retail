import { Materials } from './Materials';
import { Supplier } from './Supplier';

export interface Mapping{
//   [x: string]: number;
    id : string;
    Quantity : number;
    price : number;
    unit : string;
    material : Materials;
    supplier : Supplier;
    materialQuantity : number
}
