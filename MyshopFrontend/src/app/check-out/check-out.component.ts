import { Component, OnInit, OnDestroy } from '@angular/core';
import { ShoppingCart } from '../model/shoppingCart';
import { ShoppingCartService } from '../shopping-cart.service';
import { Subscription } from 'rxjs';
import { OrderService } from '../order.service';
import { AuthService } from '../auth.service';
import { Order } from '../model/Order';
import { Router } from '@angular/router';
import { CustomOrder } from '../model/CustomOrder';

@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.css']
})
export class CheckOutComponent implements OnInit,OnDestroy {

  
  shipping = {};
  cart:ShoppingCart;
  cartSubscription:Subscription;
  userSubscription:Subscription;
  userId:string;
  
  constructor(
    private shoppingcartService:ShoppingCartService,
    private orderservice:OrderService,
    private authService:AuthService,
    private route:Router
  ) { }

  async ngOnInit() {
   

    // let obj = await this.shoppingcartService.getCart();
    // this.cartSubscription = obj.subscribe((item:any)=>this.cart  = new ShoppingCart(item));


    let cart_= await this.shoppingcartService.getCart();
    
    this.cartSubscription = cart_.subscribe(cart => this.cart = cart);
    this.userSubscription = this.authService.user_.subscribe(user=>{
      if(user != null){
        this.userId=user.uid
      }else{
        this.userId = localStorage.getItem('u_id');
      }
      
    });
  }

  ngOnDestroy() {
    this.cartSubscription.unsubscribe();
    this.userSubscription.unsubscribe();
  }

  async placeOrder(){
    let order = new CustomOrder(this.userId,this.shipping,this.cart);


    let result = await this.orderservice.placeOrder(order);
    result.subscribe((data:any)=>{
      console.log('data',data);
      this.shoppingcartService.clearCart();
      this.route.navigate(['/order-success',data.id]);
    })
    
    ////stored id
   
  }
}
