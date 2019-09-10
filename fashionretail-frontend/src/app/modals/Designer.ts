import { List } from 'lodash';
import { DesignerOrder } from './DesignerOrder';

export interface Designer{
    
    id: string;
    contactNumber: number;
     name: string;
      city: string;
      email: string;
      rating: number;
      orderList : DesignerOrder[];
}

