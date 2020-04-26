import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from './model/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:1990/';

  constructor(private http:HttpClient) { }

  create(products:Product){
    return this.http.post(`${this.baseUrl}`+'product',products);
  }
  
  getAll(){
    return this.http.get(this.baseUrl+'product');
  }

  get(productId){
    return this.http.get(this.baseUrl+'product/'+productId);
  }

  update(productId:number,product:Product){
    return this.http.post<Product>(this.baseUrl+'updateProduct/'+productId,product);
   
  }

  delete(productId){
    return this.http.delete(this.baseUrl+'product/'+productId);
  }
}
