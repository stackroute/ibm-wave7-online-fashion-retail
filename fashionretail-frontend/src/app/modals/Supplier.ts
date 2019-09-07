import { List } from 'lodash';
import { SupplierOrder } from './SupplierOrder';

export interface Supplier{
    id : string;
    name : String;
    email : String;
    city : String;
    rating : number;
    supplierOrderList : List<SupplierOrder>
 }

 
