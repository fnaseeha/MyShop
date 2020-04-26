import { Product } from './product';

export class Item{
    //$key: string;
    id:string;
    title: string;
    imageUrl: string;
    price: number; 
    quantity: number; 

    //can have one or objects
    constructor(init?: Partial<Item>) {
        Object.assign(this, init);
      }
    
      get totalPrice() { return this.price * this.quantity; }
}