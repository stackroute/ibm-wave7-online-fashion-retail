export class Address {
  public id: string;
  public firstName: string;
  public lastName: string;
  public firstLine: string;
  public secondLine: string;
  public thirdLine: string;
  public state: string;
  public city: string;
  public pinCode: string;

  constructor(id: string,
              firstName: string,
              lastName: string,
              firstLine: string,
              secondLine: string, thirdLine: string, state: string, city: string, pinCode: string) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.firstLine = firstLine;
    this.secondLine = secondLine;
    this.thirdLine = thirdLine;
    this.state = state;
    this.city = city;
    this.pinCode = pinCode;
  }
}
