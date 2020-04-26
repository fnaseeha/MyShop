import { ShoppingCart } from './shoppingCart';

export class Order {

    items:any[];
    datePlaced:number;
    shipping:any;
    userId:string;

    constructor(userId: string,shipping: any, cart: ShoppingCart) {
        this.datePlaced = new Date().getTime();
        this.shipping = shipping;
        this.userId = userId;
        this.items = cart.items.map(i=>{
            return{
              product:{
                title:i.title,
                imageUrl:i.imageUrl,
                price:i.price
              },
              quantity:i.quantity,
              totalPrice:i.totalPrice
            }
          });
     }

    
}