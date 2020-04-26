import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from '../shopping-cart.service';
import { ShoppingCart } from '../model/shoppingCart';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  cartItemCount:number = 0;
  cart_;
  productIds:string[]=[];
  sum:number=0;

  constructor(private shoppingCartservice:ShoppingCartService) { }

 async ngOnInit() {
  // let obj = await this.shoppingCartservice.getCart();
  // obj.subscribe((item:any)=> this.cart = new ShoppingCart(item));

    this.cart_ = await this.shoppingCartservice.getCart();
  }

  clearCart(){
    let g = this.shoppingCartservice.clearCart();
    console.log('delete',g);
  }

}
