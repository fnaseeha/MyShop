import { Injectable } from '@angular/core';
import * as firebase from 'firebase';
import { AngularFireDatabase, FirebaseObjectObservable } from 'angularfire2/database';
import { AppUser } from './model/app.user';
import { HttpClient } from '@angular/common/http';
import { AppComponent } from './app.component';

@Injectable({
  providedIn: 'root'
})
export class  UserService {

  constructor(private db: AngularFireDatabase,private http: HttpClient) { }

  save(user:firebase.User){
    this.db.object('/users/'+user.uid).update({
      name:user.displayName,
      email:user.email
    })
   
  }
  get(uid: string) : FirebaseObjectObservable<AppUser>{
    return this.db.object('/users/'+uid);
  }

  getId(id:string){
    let uid = +id;
    return this.http.get(AppComponent.API_URL_LOGIN + '/user/'+uid);
  }
  
}

