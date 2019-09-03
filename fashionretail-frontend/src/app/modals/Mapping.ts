import { Materials } from './Materials';
import { Supplier } from './Supplier';

export interface Mapping{
    id : number;
    quantity : string;
    price : number;
    material : Materials;
    Supplier : Supplier;
}