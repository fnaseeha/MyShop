import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../model/product';
import { ShoppingCartService } from '../shopping-cart.service';
import { ShoppingCart } from '../model/shoppingCart';

@Component({
  selector: 'product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent {

  @Input('show-action') showAction=true;
  @Input('product') product:Product;
  @Input('shopping-cart') shoppingCart:ShoppingCart;

  constructor(private cartService:ShoppingCartService) { 
   
  }

  async addToCart(){
    
  let y = await this.cartService.addToCart(this.product);
  //  console.log('card shoppingCart',this.shoppingCart);
  //  console.log('card product',this.product);
  //  let y = this.shoppingCart.getQuantity(this.product);
    console.log('addToCart y',y);
  }

 

}
