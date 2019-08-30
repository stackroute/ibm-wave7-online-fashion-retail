import { DesignerOrder } from './DesignerOrder';
import { Mapping } from './Mapping';
import { Manufacturer } from './Manufacturer';
import { Materials } from './Materials';

export interface Dorder{
    id : number;
    designOrder : DesignerOrder
    // mapping : Mapping
    manufacturer : Manufacturer
    material : Materials
    // DesignerOrder : object;
    // Mapping : object;
    // Manufacturer : object;

}