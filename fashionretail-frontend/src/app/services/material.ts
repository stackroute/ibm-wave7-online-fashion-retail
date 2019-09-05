export class Material{
    id: number;
    category:string;
    name:string;
    image:string;

    constructor(id: number,
        category:string,
        name:string,
        image:string)
    {
        this.id=id;
        this.category=category;
        this.name=name;
        this.image=image;
    }
}