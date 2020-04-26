import { Injectable } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseUrl = "http://localhost:1991/";

  constructor(private http:HttpClient) { }

  getAll(){
    return this.http.get(this.baseUrl+'categories');
  }
}
