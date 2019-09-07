import { Mapping } from './Mapping';
import { Materials } from './Materials';
import { Designer } from './Designer';
import { Supplier } from './Supplier';
import { Design } from './Design';
import { List } from 'lodash';
import { Manufacturer } from './Manufacturer';

export interface DesignerOrder{
  designOrder: Design;
  mapping: any;
  designer: Designer;
    id : String;
    tagId : string;
    design : Design;
    manufacturer : Manufacturer;
    supplierList : List<Map<Mapping,number>>
    // designer : Designer;

}  
   