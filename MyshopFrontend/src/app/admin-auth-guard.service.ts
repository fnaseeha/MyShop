import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';
import { AuthService } from './auth.service';
import { UserService } from './user.service';

import { Observable } from 'rxjs/observable';
import { Auth1Service } from './auth1.service';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthGuardService implements CanActivate {

  constructor(private auth:AuthService,private userService:UserService,private auth1:Auth1Service) { }

  canActivate():Observable<boolean>{
    // console.log('booolean',this.auth.appUser_.map(appuser=>appuser.admin));

    return this.auth1.appUser_.map(appuser=>appuser.admin);
    // console.log('this.auth.appUser_',this.auth.appUser_);
     
    // return this.auth.appUser_
    //   .map(appUser => appUser.admin);

  }
}
