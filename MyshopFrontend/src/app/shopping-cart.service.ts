import { Injectable } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';
import { Product } from './model/product';
import 'rxjs/add/operator/take';
import 'rxjs/add/operator/map';
import { Item } from './model/item';
import { Observable } from 'rxjs/Observable';
import { ShoppingCart } from './model/shoppingCart';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  private baseUrl = 'http://localhost:1992';

  cartId: string;
  constructor(private http: HttpClient) { }

  async removeFromCart(product: Product) {
     this.updateItem(product, -1);
  }

  async addToCart(product: Product) {
    console.log('addingCartProduct',product);
    this.updateItem(product, 1);
   // console.log(d);
  }
  ////localhost:1992/shopping-cart-item/1 /shopping-cart/1 : Promise<Observable<ShoppingCart>> 
  async getCart(): Promise<Observable<ShoppingCart>> {
    let cartId = await this.getOrCreateCartId();
    let y = +cartId;
    //let url = `${this.baseUrl}`+'/shopping-cart/' + y;
    let url2 = `${this.baseUrl}` + '/shopping-cart-items/' + y;
    console.log('get ', url2);
    // return this.http.get(url2)
    //   .map((x:any) => new ShoppingCart((x!=null)?x.items:null));
    return this.http.get(url2).map((x)=>new ShoppingCart(x));
  }

  async clearCart() {
    let cartId = await this.getOrCreateCartId();
    let y = +cartId;
    this.http.delete(this.baseUrl + '/shopping-cart/' + y) .subscribe((data) => console.log('Delete data',data));;
  }
  private create() {
    let time = new Date().getTime();
    console.log('time', time);
    return this.http.get(`${this.baseUrl}` + '/shopping-cart-create/' + time);
  }

  private getItem(itemId: string) {
    let y = +itemId
    console.log('id y',itemId);
    return this.http.get(`${this.baseUrl}` + '/shopping-cart-item/' + y).subscribe((data)=>{
        console.log('getItem data',data);
    });
  }

  private removeItem(itemId: string) {
    let y = +itemId
    return this.http.delete(`${this.baseUrl}` + '/shopping-cart-item/' + y)
    .subscribe((data) =>{ 
      console.log(data);
      
    });
  }

  private updateItemObj(item: Item, cartId: string,change:number) {
    //console.log('updateItemObj1', item);
   // console.log('cartId', Number(cartId));
    let y = +cartId;
     this.http.post(`${this.baseUrl}` + '/shopping-cart-item/' + y+ '/' +change, item)
    .subscribe(
      (data) => {
        console.log('updateItemObj',data);
      }
    );
  }

  private async getOrCreateCartId(): Promise<string> {
    let cartId = localStorage.getItem('cartId');

    if (cartId) return cartId;
    let result: any;
    result = await this.create();
    result.subscribe(result => {
      localStorage.setItem('cartId', result.id);
      return result.id;
    });
  }

  private async updateItem(product: Product, change: number) {
    let cartId = await this.getOrCreateCartId();
    console.log(' updateItem cartId', cartId);
    console.log('product',product);

  //  let item$ = this.getItem(product.id);
    let item_ = new Item();
    item_.imageUrl = product.imageUrl;
    item_.price = Number(product.price);
    item_.quantity = change;
    item_.title = product.title;
     this.updateItemObj(item_, cartId,change);
    // item$.take(1).subscribe((item: Item) => {


    //   let quantity = ((item == null) ? 0 : item.quantity) + change;
    //   console.log('quantity ',quantity);
    //   console.log('product ',product);
    //   console.log('change ',change);
    //  // console.log('item ',item); null

     
    //   // if (quantity === 0) {
    //   //   this.removeItem(item.id); //item$.remove();
    //   // } else {
        
    //   // }
    // });
  }
}
