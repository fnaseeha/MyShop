import { Injectable } from '@angular/core';
//import { Http, Headers, RequestOptions, Response} from '@angular/http';

import {Router, ActivatedRoute} from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AppComponent } from './app.component';
import { User } from './model/User';
import { map } from 'rxjs/operators';
import { AppUser } from './model/app.user';
import { Observable } from 'rxjs/internal/Observable';
import { LocalStorage } from '@ngx-pwa/local-storage';

@Injectable()
export class Auth1Service {
 
  user_:Observable<Object>;

  constructor(
    private http: HttpClient,
     private route:ActivatedRoute, 
     private router: Router,protected localStorage1: LocalStorage) { }

  public errorMessage = '';
  authenticated = false;

 login(username,password) {
    let returnUrl = this.route.snapshot.queryParamMap.get('returnUrl') ||'/';
    localStorage.setItem('returnUrl',returnUrl);
    this.user_= this.http.get(AppComponent.API_URL_LOGIN + '/login/'+username+'/'+password);
  
    return this.user_;
  }

  createAccount(user: User) {
    return this.http.post(AppComponent.API_URL_LOGIN + '/register', user);
  }

  getId(id:string):Observable<AppUser>{
    let uid = +id;
    console.log('url '+AppComponent.API_URL_LOGIN + '/user/'+id);
    return this.http.get<AppUser>(AppComponent.API_URL_LOGIN + '/user/'+id);
  }

  get appUser_() :Observable<AppUser>{
   let id =  localStorage.getItem('u_id');
   console.log('id is >>'+id);
   if(id != null){
     return this.getId(id);
   }
  }
  
 

}