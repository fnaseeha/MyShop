import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './model/User';
import { AppComponent } from './app.component';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(public http: HttpClient) { }

  createAccount(user: User) {
    return this.http.post(AppComponent.API_URL_LOGIN + '/register', user);
  }
}
