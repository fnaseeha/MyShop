import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  errorMessage: string;
  
  constructor(private accountService: AccountService, private router: Router) { }


  register() {
    console.log('register',this.user);
    this.accountService.createAccount(this.user).subscribe(data => {
      console.log('register SER data ',data);
        this.router.navigate(['login']);
      }, err => {
        console.log(err);
        this.errorMessage = 'username already exist';
      }
    );
  }
  ngOnInit() {
  }

}
