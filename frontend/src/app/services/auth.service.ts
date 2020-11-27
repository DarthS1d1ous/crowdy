import {Injectable} from '@angular/core';
import {BehaviorSubject, Subject} from 'rxjs';
import {Router} from '@angular/router';
import {HttpClient} from "@angular/common/http";
import {UserRegister} from "../models/user-register";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public isAuthenticated = new BehaviorSubject<boolean>(false);
  authErrorMessage: Subject<string>;

  constructor(private router: Router, private httpClient: HttpClient) {
    this.authErrorMessage = new Subject<string>();
  }

  async checkAuthenticated() {
    const isAuthenticated = localStorage.getItem("isAuthenticated");
    return !!isAuthenticated;
  }

  login(username: string, password: string) {
    return this.httpClient.post<{ username: string, password: string }>('http://localhost:8081/login', {
      username: username,
      password: password
    }).subscribe(authResponse => {
      if (!authResponse) {
        this.authErrorMessage.next("Auth error occurred");
      } else {
        this.isAuthenticated.next(true);
        localStorage.setItem('user', JSON.stringify(authResponse));
        localStorage.setItem("isAuthenticated", "true");
        this.authErrorMessage.next("");
        this.router.navigate(['/']);
      }
    })
  }

  register(user: UserRegister) {
    return this.httpClient.post(`http://localhost:8081/register`, user);
  }

  async logout(redirect: string) {
    try {
      this.isAuthenticated.next(false);
      localStorage.removeItem("isAuthenticated");
      await this.router.navigate([redirect]);
    } catch (err) {
      console.error(err);
    }
  }
}
