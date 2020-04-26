import { Component, OnInit, OnDestroy } from '@angular/core';
import { CategoryService } from '../../category.service';
import { ProductService } from '../../product.service';
import { Router, ActivatedRoute } from '@angular/router';
import 'rxjs/add/operator/take';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-product-form', 
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnDestroy{

  
  categories_;
  product = {};
  id;
  subscribtion:Subscription;

  constructor(
    private router:Router,
    private route:ActivatedRoute,
    private categoryService:CategoryService,private productService:ProductService) {
    this.categories_ = categoryService.getAll();

    this.id = this.route.snapshot.paramMap.get('id')
   
    if(this.id){
      this.productService.get(this.id).take(1).subscribe(
        p => this.product = p
      );
    }
   }

   async save(product){
     console.log('save',product);

     if(this.id){
      let d = await this.productService.update(this.id,product);
      this.subscribtion = d.subscribe((data)=> console.log('updateProduct',data));
    
     }else{
     let d= await this.productService.create(product);
     this.subscribtion = d.subscribe((data)=>{
        console.log('saveProduct',data);
     });
      
     }
     this.router.navigateByUrl('/', { skipLocationChange: true });
    this.router.navigate(['admin/products']);
   }

   async delete(){
     if(!confirm('Are you sure want to delete this product? ')) return;
     let d = this.productService.delete(this.id);
     d.subscribe((data)=>{console.log('deleteProduct',data);})
     this.router.navigate(['admin/products']);
   }

   ngOnDestroy() {
     if(this.subscribtion!=null){
      this.subscribtion.unsubscribe();
     }
   
  }
}
