import { Component, OnInit, Input } from '@angular/core';
import { ShoppingCartService } from '../shopping-cart.service';
import { Product } from '../model/product';
import { ShoppingCart } from '../model/shoppingCart';

@Component({
  selector: 'product-quantity',
  templateUrl: './product-quantity.component.html',
  styleUrls: ['./product-quantity.component.css']
})
export class ProductQuantityComponent  {

  @Input('product') product:Product;
  @Input('shopping-cart') shoppingCart:ShoppingCart;
  
  constructor(private cartService:ShoppingCartService) { }

  async addToCart(){
    console.log(this.product);
   let y = await this.cartService.addToCart(this.product);
   console.log('y',y);
  }

  async removeFromCart(){
    let y = await this.cartService.removeFromCart(this.product);
    console.log('y',y);
  }

  


}
