export class Designer {
  id: number;
  contact: number;
  name: string;
  location: string;
  email: string;
  rating: number;

  constructor(id: number, contact: number, name: string, location: string, email: string, rating: number) {
    this.id = id;
    this.contact = contact;
    this.name = name;
    this.location = location;
    this.email = email;
    this.rating = rating;
  }
}
