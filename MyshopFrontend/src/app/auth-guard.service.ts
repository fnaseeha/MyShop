import { Injectable } from '@angular/core';
import { CanActivate, Route, Router, RouterStateSnapshot } from '@angular/router';
import { AuthService } from './auth.service';
import 'rxjs/add/operator/map';
import { Auth1Service } from './auth1.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private auth:AuthService,private auth1:Auth1Service, private router:Router) { }

  canActivate(route, state:RouterStateSnapshot){
   if(this.auth1.appUser_== null){
    this.router.navigate(['/login'], {queryParams: {returnUrl:state.url}});
    return false;
   }else{
    return this.auth1.appUser_.map(user=>{
      if(user) return true;
      
      this.router.navigate(['/login'], {queryParams: {returnUrl:state.url}});
      return false;
    });
   }
    

  //  return this.auth.user_.map(user => {
  //     if(user) return true;
      
  //     this.router.navigate(['/login'], {queryParams: {returnUrl:state.url}});
  //     return false;
  //   });
  }
 
}
