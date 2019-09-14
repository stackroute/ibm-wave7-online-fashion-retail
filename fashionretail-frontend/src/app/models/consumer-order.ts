import {Product} from './product';
import {Address} from './address';

export class ConsumerOrder {
  id: string;
  consumerId: string;
  products: Product[];
  totalAmount: number;
  shippingAddress: Address;
  status: string;
  date: Date;
}
