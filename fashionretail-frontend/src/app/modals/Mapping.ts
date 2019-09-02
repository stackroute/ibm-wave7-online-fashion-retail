import { Materials } from './Materials';
import { Supplier } from './Supplier';

export interface Mapping{
    id : number;
    quantity : Uint16Array;
    price : DoubleRange;
    material : Materials;
    Supplier : Supplier;
}