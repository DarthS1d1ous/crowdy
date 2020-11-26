import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {Router} from '@angular/router';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public isAuthenticated = new BehaviorSubject<boolean>(false);

  constructor(private router: Router, private httpClient: HttpClient) {
  }

  async checkAuthenticated() {
    // const authenticated = await this.authClient.session.exists();
    // this.isAuthenticated.next(authenticated);
    // return authenticated;
    return false;
  }

  async login(username: string, password: string) {
    // const transaction = await this.authClient.signIn({username, password});
    //
    // if (transaction.status !== 'SUCCESS') {
    //   throw Error('We cannot handle the ' + transaction.status + ' status');
    // }
    // this.isAuthenticated.next(true);
    //
    // this.authClient.session.setCookieAndRedirect(transaction.sessionToken);
    this.httpClient.post('http://localhost:8081/login', {
      username: username,
      password: password
    });
  }

  async register(user: User) {
    return this.httpClient.post(`http://localhost:8081/users`, user);
  }

  async logout(redirect: string) {
    // try {
    //   await this.authClient.signOut();
    //   this.isAuthenticated.next(false);
    //   await this.router.navigate([redirect]);
    // } catch (err) {
    //   console.error(err);
    // }
  }
}
