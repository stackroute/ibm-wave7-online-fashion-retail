import { Address } from './address';
import { Product } from './product';
import { List } from 'lodash';
import { ConsumerOrder } from './consumer-order';

export class Consumer{

    id : string;
    userName: string;
    email: string;
     addresses : Map<String,Address>;
    consumerOrders :  Map<String,ConsumerOrder> ;
    cart : List<Product> ;

constructor( id : string,
    userName: string,
    email: string,
     addresses : Map<String,Address>,
    consumerOrders :  Map<String,ConsumerOrder> ,
    cart : List<Product> )
    {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.addresses = addresses;
        this.consumerOrders = consumerOrders;
        this.cart = cart;
    }
}
