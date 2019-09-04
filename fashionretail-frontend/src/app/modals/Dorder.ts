import { DesignerOrder } from './DesignerOrder';
import { Mapping } from './Mapping';
import { Manufacturer } from './Manufacturer';
import { Materials } from './Materials';
import { Designer } from './Designer';

export interface Dorder{
    id : String;
    designOrder : DesignerOrder
    // mapping : Mapping
    manufacturer : Manufacturer
    mapping : Array<Mapping>
    designer : Designer
    // DesignerOrder : object;
    // Mapping : object;
    // Manufacturer : object;

}