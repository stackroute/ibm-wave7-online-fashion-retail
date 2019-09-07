import { Designer } from '../classes/designer';
import { Material } from '../services/material';

export interface SupplierOrder{
    id: string;
    designerName : string;
    material : Material;
    quantity : number;
    orderStatus : string;
    tagId: string;
}

