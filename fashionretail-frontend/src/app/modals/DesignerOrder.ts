import { Key } from 'protractor';

export interface DesignerOrder{
    id : String;
    name : String;
    price : number;
    discount : number;
    profit : number;
    QuantityOfDesign : number;
    OrderStatus : String;
    design_img : string;
}
