import { Injectable } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';
import { ShoppingCartService } from './shopping-cart.service';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from './app.component';
import { CustomOrder } from './model/CustomOrder';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private db:AngularFireDatabase,
    private shoppingCartService:ShoppingCartService,
    private http:HttpClient) { }

  async placeOrder(order:CustomOrder){
    console.log('order',order);

   return this.http.post(AppComponent.API_URL_ORDER+'/create',order);
   // let result= await this.db.list('/orders').push(order);

  //  let result = await this.orderservice.placeOrder(order);
  //  result.subscribe((data)=>{
  //    console.log('data',data);
  //  })

    
  }

  getOrdersById(){
    let id =  localStorage.getItem('u_id');
    return this.http.get(AppComponent.API_URL_ORDER+'/getOrder/'+Number(id));
  }
  getOrders(){
   // return this.db.list('/orders');
   return this.http.get(AppComponent.API_URL_ORDER+'/getOrder');
  }
}
