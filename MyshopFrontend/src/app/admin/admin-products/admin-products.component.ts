import { Component, OnInit, OnDestroy } from '@angular/core';
import { ProductService } from '../../product.service';
import { Subscription } from 'rxjs';
import { Product } from '../../model/product';

@Component({
  selector: 'app-admin-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.css']
})
export class AdminProductsComponent implements OnInit,OnDestroy {

  
  products: Product[];
  filteredProducts:Product[];
  subscription:Subscription;
  items: Product[] = [];
  itemCount: number;

  constructor(private productService:ProductService) {
    this.subscription = this.productService.getAll()
    .subscribe((products:Product[]) => {
       this.filteredProducts = this.products = products;
    });

   }
  //  private initialzeTable(products: Product[]){
    
  //   this.tableResource = new DataTableResource(products);
  //   this.tableResource.query({offset:0})
  //     .then(items => this.items = items);
  //   this.tableResource.count()
  //   .then(count=>this.itemCount = count)
     
  //  }

   filter(query){
     this.filteredProducts = (query) ?
      this.products.filter(p=>p.title.toLowerCase()
      .includes(query.toLowerCase())) :
      this.products;
   }

  //  reloadItems(params){
  //   if(!this.tableResource) return;

  //   this.tableResource.query(params)
  //   .then(items => this.items = items);
  //  }

   ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  ngOnInit() {
  }

}
