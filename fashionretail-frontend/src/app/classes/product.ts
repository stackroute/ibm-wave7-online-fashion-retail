export class Product {
  id: string;
  name: string;
  category: string;
  designerName: string;
  price: number;
  discount: number;
  rating: number;
  image: string;

  constructor(id: string,
              name: string,
              category: string,
              designerName: string,
              price: number,
              discount: number,
              rating: number,
              image: string) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.designerName = designerName;
    this.price = price;
    this.discount = discount;
    this.rating = rating;
    this.image = image;
  }
}
