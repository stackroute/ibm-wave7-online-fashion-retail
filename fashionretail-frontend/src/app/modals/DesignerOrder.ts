import { Key } from 'protractor';

export interface DesignerOrder{
    id : number;
    name : String;
    price : number;
    discount : number;
    profit : number;
    QualityOfDesign : number;
    OrderStatus : String;
}
