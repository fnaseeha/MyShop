import { Component, OnInit } from '@angular/core';
import * as firebase from 'firebase';
import { AngularFireAuth } from 'angularfire2/auth';
import { AuthService } from '../auth.service';
import { Auth1Service } from '../auth1.service';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { MyUser } from '../model/my.user';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  user: User = new User();
  errorMessage: string;
  
  constructor(
    private auth:AuthService,
    private auth1:Auth1Service,
    private router: Router) {
    
   }

  login(){
    this.auth.login();
  }

  login1(){
    this.auth1.login(this.user.username,this.user.password).subscribe((user:any) => {
      console.log('user',user);
      localStorage.setItem('u_admin', user.admin);
      localStorage.setItem('u_id', user.id);
      localStorage.setItem('u_name', user.name);
      localStorage.setItem('u_email', user.email);
      this.router.navigateByUrl('/');
    
    });
    return false;
  }
  
}
