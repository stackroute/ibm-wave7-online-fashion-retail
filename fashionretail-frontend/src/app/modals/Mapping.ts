import { Materials } from './Materials';
import { Supplier } from './Supplier';

export interface Mapping{
    id : string;
    Quantity : number;
    price : number;
    unit : string;
    material : Materials;
    supplier : Supplier;
}
