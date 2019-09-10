export class Material {
  id: string;
  category: string;
  name: string;
  image: string;

  constructor(id: string,
              category: string,
              name: string,
              image: string) {
    this.id = id;
    this.category = category;
    this.name = name;
    this.image = image;
  }
}
