import { Materials } from './Materials';
import { Supplier } from './Supplier';

export interface Mapping{
    id : number;
    Quantity : string;
    price : number;
    designerEnterQuantity: string;
    material : Materials;
    supplier : Supplier;
}