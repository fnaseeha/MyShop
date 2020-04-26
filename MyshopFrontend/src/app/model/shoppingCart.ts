import { Item } from './item';
import { Product } from './product';

export class ShoppingCart {
    items: Item[] = [];

    constructor(private itemsMap: any) {
        this.itemsMap = itemsMap || {};

        //console.log('constructor sho ',this.itemsMap);

        for (let productId in itemsMap) {
            let item = itemsMap[productId];
            //console.log('item ',item);
            this.items.push(new Item({ ...item }));
        }
    }
    get totalIemsCount() {
        let count = 0;
        for (let productId in this.items)
            count += this.items[productId].quantity;
        return count;
    }

    getQuantity(product: Product) {
        if(product==undefined) return 0;
        else{
            //console.log('sho product',product.title);
            //console.log('this.items',this.items);
            //this.personService.getPersons().find(x => x.id == this.personId);
            let item = this.items.find(x=>x.title==product.title);
            // if(item=null){
            //    // console.log('y',item1.quantity);
            //     return item.quantity;
            // }
            
           // let item = this.itemsMap[product.id];
            return item ? item.quantity : 0;
        }
         
    }

    get totalPrice() {
        let sum = 0;
        for (let productId in this.items)
            sum += this.items[productId].totalPrice;
        return sum;
    }

    //totalPrice
}