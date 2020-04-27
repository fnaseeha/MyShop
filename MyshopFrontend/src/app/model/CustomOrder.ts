import { ShoppingCart } from './shoppingCart';
import { CustomItem } from './CustomItem';

export class CustomOrder {

    items:Array<CustomItem>=[];
    dateCreated:number;
    shipping:any;
    user_id:number;
    ship_name:string;
    ship_addressLine1:string;
    ship_addressLine2:string;
    ship_city:string;
    total:number;

    constructor(userId: string,shipping: any, cart: ShoppingCart) {
        this.dateCreated = new Date().getTime();
        this.user_id = Number(userId);
        this.ship_name = shipping.name;
        this.ship_addressLine1 = shipping.addressLine1;
        this.ship_addressLine2 = shipping.addressLine2;
        this.ship_city = shipping.city;
        this.total = cart.totalPrice;

        cart.items.forEach(e => {
            let k = {
                "price":e.price,
                "product_id":Number(e.id),
                "quantity":e.quantity
            }
          // let g = new CustomItem(Number(e.id),e.quantity,e.price);
           this.items.push(k);
        });
      
        // cart.items.map(i=>{
        //     return{
        //         product_id: i.id,
        //         quantity: i.quantity,
        //         price: i.price, 
        //     }
        //   });
     }

    
}