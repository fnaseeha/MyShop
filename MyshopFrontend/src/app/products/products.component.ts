import { Component, OnInit, OnDestroy } from '@angular/core';
import { ProductService } from '../product.service';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../model/product';
import 'rxjs/add/operator/switchMap';
import { ShoppingCartService } from '../shopping-cart.service';
import { Subscription } from 'rxjs';
import { ShoppingCart } from '../model/shoppingCart';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit,OnDestroy{

  products: Product[] = [];
  filteredProduct:Product[] = []; 
  category:string;
  cart : any;
  suscribtion : Subscription;


  constructor(
    private shoppingCartService:ShoppingCartService,
    route:ActivatedRoute,
    productService: ProductService) { 
    productService
    .getAll()
    .switchMap((products : Product[])=> {
      this.products = products;
      return route.queryParamMap;
     
    })
    .subscribe(params=>{
      this.category = params.get('category');

      this.filteredProduct = (this.category)?
       this.products.filter(p=>p.category===this.category) :
       this.products;
       console.log('products', this.products);
    });
     
  }

  async ngOnInit(){
   

    // let obj = await this.shoppingCartService.getCart();
    // this.suscribtion = obj.subscribe((item:any)=>{
    //   this.cart  = new ShoppingCart(item);
    //   console.log('product cart',this.cart);
    // });

   this.suscribtion = (await this.shoppingCartService.getCart()).subscribe(cart => {
     this.cart = cart;
     console.log(cart);
    });
  }
  ngOnDestroy() {
    this.suscribtion.unsubscribe();
  }

}
