import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {AuthService} from "../../services/auth.service";
import {UserRegister} from "../../models/dto/user-register";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit, OnDestroy {

  form: FormGroup;
  public registerInvalid: boolean;
  registerErrorMessage: string;
  imageSrc: string;
  private formSubmitAttempt: boolean;
  private returnUrl: string;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authService: AuthService
  ) {
  }

  get f() {
    return this.form.controls;
  }

  async ngOnInit() {
    this.authService.authErrorMessage.subscribe(authErrorMessage => this.registerErrorMessage = authErrorMessage);

    this.returnUrl = '/';

    this.form = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(4)]],
      fullName: ['', [Validators.required, Validators.minLength(4)]],
      birthday: ['', [Validators.required]],
      file: [''],
      fileSource: [''],
      password: ['', Validators.required]
    });

    if (this.authService.checkAuthenticated()) {
      this.router.navigate([this.returnUrl]);
    }
  }

  onSubmit() {
    this.registerInvalid = false;
    this.formSubmitAttempt = false;
    if (this.form.valid) {
      const username = this.form.get('username').value;
      const fullName = this.form.get('fullName').value;
      const birthday = this.form.get('birthday').value;
      const fileSource = this.form.get('fileSource').value;
      const password = this.form.get('password').value;
      this.authService.register(new UserRegister(username, password, fullName, birthday, fileSource))
        .subscribe(value => {
          if (value) {
            this.authService.login(username, password);
          } else {
            this.registerErrorMessage = 'Username is already in use';
          }
        })
    } else {
      this.formSubmitAttempt = true;
    }
  }

  onFileChange(event) {
    const reader = new FileReader();

    if (event.target.files && event.target.files.length) {
      const [file] = event.target.files;
      reader.readAsDataURL(file);

      reader.onload = () => {
        this.imageSrc = reader.result as string;
        this.form.patchValue({
          fileSource: reader.result
        });
      };

    }
  }

  ngOnDestroy(): void {
    this.authService.authErrorMessage.unsubscribe();
  }
}
