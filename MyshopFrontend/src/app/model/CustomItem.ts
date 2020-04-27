
export class CustomItem{
    product_id: number;
    price: number; 
    quantity: number; 

    constructor(product_id: number,price: number, quantity: number) {
        this.price=price,
        this.product_id=product_id;
        this.quantity = quantity;
    }
}
