import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { AppUser } from '../model/app.user';
import { ShoppingCartComponent } from '../shopping-cart/shopping-cart.component';
import { ShoppingCartService } from '../shopping-cart.service';
import { ShoppingCart } from '../model/shoppingCart';
import { Observable, Subscription } from 'rxjs';
import { User } from '../model/User';
import { MyUser } from '../model/my.user';
import { Auth1Service } from '../auth1.service';

@Component({
  selector: 'bs-navbar',
  templateUrl: './bs-navbar.component.html',
  styleUrls: ['./bs-navbar.component.css']
})
export class BsNavbarComponent implements OnInit{

 
  appUser:AppUser;
  cartItemCount:number;
  cart_;
  user:MyUser;
  //subscribtion:Subscription;

  constructor(public auth:AuthService,private shoppingCartservice:ShoppingCartService,private auth1:Auth1Service) {
     
   }

   async ngOnInit() {
    this.auth.appUser_.subscribe(appUser => this.appUser = appUser);
       console.log('this.appUser ',this.appUser);
    if(this.appUser ==null){
      this.auth1.appUser_.subscribe(appUser =>{
        this.appUser = appUser;
      })
    }


     this.cart_ = await this.shoppingCartservice.getCart();
     
    //  this.cart_.subscribe(cart =>{
    //    this.cartItemCount = 0;
    //     for(let productId in cart.items)
    //        this.cartItemCount += cart.items[productId].quantity;
    //  });
  }

   logout(){
     this.auth.logout();
     localStorage.removeItem('u_id');
   }
  

}
