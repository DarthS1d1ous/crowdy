import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Store} from "@ngrx/store";
import * as fromApp from '../store/app.reducer';
import * as AuthActions from './store/auth.actions';
import {HttpClient} from "@angular/common/http";
import {UserRegister} from "../model/dto/user-register";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  loginForm: FormGroup;
  signupForm: FormGroup;
  isLoginMode = true;
  confirmPassword: string;
  base64image!: string;
  hideLogInPassword = true;
  hideSignUpPassword = true;
  hideSignUpConfirmPassword = true;

  constructor(private fb: FormBuilder,
              private store: Store<fromApp.AppState>,
              private httpClient: HttpClient) {
    this.confirmPassword = '';
    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
    this.signupForm = this.fb.group({
      username: ['', [Validators.required]],
      password: this.fb.group({
        password: ['', [Validators.required, Validators.minLength(6)]],
        confirmPassword: ['', [Validators.required]]
      }, {validators: this.checkPasswords}),
      fullName: ['', [Validators.required]],
      birthday: ['', [Validators.required]],
      avatar: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {

  }

  switchMode(): void {
    this.isLoginMode = !this.isLoginMode;
  }

  checkPasswords(group: FormGroup): any {
    return group.controls['password'].value === group.controls['confirmPassword'].value
      ? null
      : {notTheSame: true}
  }

  onPasswordInput() {
    if (this.signupForm.get('password')?.hasError('notTheSame'))
      this.signupForm.get('password.confirmPassword')?.setErrors([{'passwordMismatch': true}]);
    else
      this.signupForm.get('password.confirmPassword')?.setErrors(null);
  }

  onSubmitLoginForm(): void {
    if (this.loginForm.invalid) {
      return;
    }
    const payload = {
      username: this.loginForm.value.username,
      password: this.loginForm.value.password
    }
    this.store.dispatch(new AuthActions.LoginStart(payload));
  }

  getBase64(event: any): void {
    let file = event.target.files[0];
    let reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
      console.log(reader.result);
    };
    reader.onerror = function (error) {
      console.log('Error: ', error);
    };
  }

  handleFileSelect() {
    let file = this.signupForm.value.avatar;
    if (file) {
      let reader = new FileReader();
      reader.onload = this.handleReaderLoaded.bind(this);
      reader.readAsBinaryString(file);
    }
  }

  handleReaderLoaded(readerEvt: any) {
    this.base64image = btoa(readerEvt.target.result);
  }

  onSubmitSignupForm(): void {
    if (this.signupForm.invalid) {
      return;
    }
    const user = new UserRegister(
      this.signupForm.value.username,
      this.signupForm.value.password.password,
      this.signupForm.value.fullName,
      this.signupForm.value.birthday,
      this.base64image,
    )
    console.log(user)
    this.store.dispatch(new AuthActions.SignupStart(user));
  }

  login(): void {
    this.httpClient.post<any>('http://localhost:8090/login', {
      username: 'denis2000',
      password: 'denis2000'
    }).subscribe(authResponse => {
      console.log(authResponse)
    });
  }


}
