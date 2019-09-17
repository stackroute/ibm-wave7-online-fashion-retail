import {Design} from './Design';
import {Manufacturer} from './Manufacturer';

export class DesignerOrder {
  id: string;
  designOrder: Design;
  supplierList: Map<string, number>[];
  manufacturer: Manufacturer;
  tagId: string;

  constructor(id: string, designer_id : string,designOrder: Design, supplierList: Map<string, number>[], manufacturer: Manufacturer, tagId: string) {
    this.id = id;
    this.designOrder = designOrder;
    this.supplierList = supplierList;
    this.manufacturer = manufacturer;
    this.tagId = tagId;
  }
}
