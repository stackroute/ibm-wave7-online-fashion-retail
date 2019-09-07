import { List } from 'lodash';
import { ManufacturerOrder } from './ManufacturerOrder';
import { BasePrice } from './BasePrice';

export interface Manufacturer{
    id : number;
    name : string;
    email : string;
    contact_number: number; 
    specifications: string;
    city: string;
    rating: number;
    basePrice : List<BasePrice>;
    manufacturerOrder : List<ManufacturerOrder>
 }