import { Injectable } from '@angular/core';
import { AngularFireAuth } from 'angularfire2/auth';
import { Observable } from 'rxjs/Observable';
import * as firebase from 'firebase';
import { ActivatedRoute } from '@angular/router';
import { AppUser } from './model/app.user';
import { UserService } from './user.service';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/observable/of';
import { HttpClient } from '@angular/common/http';
import { Auth1Service } from './auth1.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user_:Observable<firebase.User>;
  
  constructor(
    private userService:UserService,
    private afAuth:AngularFireAuth, 
    private route:ActivatedRoute,private auth1:Auth1Service) { 

    this.user_ = this.afAuth.authState;
  }

  login(){
    let returnUrl = this.route.snapshot.queryParamMap.get('returnUrl') ||'/';
    localStorage.setItem('returnUrl',returnUrl);
    this.afAuth.auth.signInWithRedirect(new firebase.auth.GoogleAuthProvider());
  }

  logout(){
    this.afAuth.auth.signOut();
  }

  get appUser_() : Observable<AppUser>{
    
    return this.user_
    .switchMap(user => {
      if(user){ 
        return this.userService.get(user.uid);
      }else{
        console.log('user.....................',user);
        return Observable.of(null);
      }
     
    })
    
  }
}
