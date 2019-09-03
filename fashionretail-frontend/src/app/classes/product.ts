import {Designer} from './designer';

export class Product {
  id: string;
  name: string;
  category: string;
  designer: Designer;
  price: number;
  discount: number;
  rating: number;
  image: string;

  constructor(id: string,
              name: string,
              category: string,
              designer: Designer,
              price: number,
              discount: number,
              rating: number,
              image: string) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.designer = designer;
    this.price = price;
    this.discount = discount;
    this.rating = rating;
    this.image = image;
  }
}
