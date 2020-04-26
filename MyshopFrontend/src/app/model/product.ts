export class Product{
    id:string;
   // $key: string;
    title: string;
    price: number;
    category: string;
    imageUrl: string;
    quantity: number; 

    constructor(title: string,price: number, category: string,imageUrl:string) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.imageUrl = imageUrl;
       
     }
}