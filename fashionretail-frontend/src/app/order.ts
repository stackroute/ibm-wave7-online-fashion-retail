export class IOrder {
    id:number;
    customer_name:string;
    material:string;
    unit:string;
    quantity:number;
constructor(id: number,customer_name:string,material:string,unit:string,quantity:number)
{
    this.id=id;
    this.customer_name=customer_name;
    this.material=material;
    this.unit=unit;
    this.quantity = quantity;
}
}