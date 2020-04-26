import { Component, OnInit } from '@angular/core';
import { OrderService } from '../../order.service';
import { Order } from '../../model/Order';

@Component({
  selector: 'app-admin-orders',
  templateUrl: './admin-orders.component.html',
  styleUrls: ['./admin-orders.component.css']
})
export class AdminOrdersComponent {
  orders$;

  constructor(private orderService: OrderService) { 
    this.orders$ = orderService.getOrders();
    console.log(this.orders$);
  }
}
