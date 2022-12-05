import { Component, OnInit } from '@angular/core';
import {LoginService} from '../service/login.service';
import {Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  appUserForm: FormGroup;
  constructor(private loginService: LoginService,
              private router: Router,
              private toast: ToastrService) { }

  ngOnInit(): void {
    this.appUserForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    });
  }

  login(){
    const appUser = this.appUserForm.value;
    if (appUser.username === '' || appUser.password === ''){
      this.toast.error('Hãy nhập đủ tài khoản và mật khẩu');
      return;
    }
    this.loginService.login(appUser).subscribe(
      value => {
        sessionStorage.setItem('username', appUser.username);
        const tokenStr = 'Bearer ' + value.token;
        sessionStorage.setItem('token', tokenStr);
        sessionStorage.setItem('roles', value.roles[0].authority);
        this.toast.success('Đăng nhập thành công');
        this.router.navigateByUrl('');
      },
      error => {
        this.toast.error('Tài khoản hoặc mật khẩu không chính xác');
      }
    );
  }
}
