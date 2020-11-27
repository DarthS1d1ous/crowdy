import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {
  form: FormGroup;
  public loginInvalid: boolean;
  private formSubmitAttempt: boolean;
  private returnUrl: string;
  authErrorMessage: string;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authService: AuthService
  ) {
  }

  async ngOnInit() {
    this.authService.authErrorMessage.subscribe(authErrorMessage => this.authErrorMessage = authErrorMessage);

    this.returnUrl = '/';

    this.form = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(4)]],
      password: ['', Validators.required]
    });

    if (await this.authService.checkAuthenticated()) {
      await this.router.navigate([this.returnUrl]);
    }
  }

  onSubmit(event: any) {
    if (event.submitter.name === 'login') {
      console.log('login')
      this.loginInvalid = false;
      this.formSubmitAttempt = false;
      if (this.form.valid) {
        const username = this.form.get('username').value;
        const password = this.form.get('password').value;
        this.authService.login(username, password);
      } else {
        this.formSubmitAttempt = true;
      }
    } else {
      this.router.navigate(['register']);
    }
  }

  ngOnDestroy(): void {
    this.authService.authErrorMessage.unsubscribe();
  }
}
