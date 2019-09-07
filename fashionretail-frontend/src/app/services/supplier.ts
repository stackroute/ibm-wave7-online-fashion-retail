export class Supplier {
    id: number;
    name: string;
    email: string;
    city: string;
    rating: string;
    

    constructor(id: number,name:string,email:string,city:string,rating:string)
{
    this.id=id;
    this.name=name;
    this.email=email;
    this.city=city;
    this.rating=rating;
}
}