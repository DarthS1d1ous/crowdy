import {Injectable} from '@angular/core';

@Injectable()
export class SignService {
  private loggedIn = false;

  constructor() {
  }

  isLoggedIn(): boolean {
    return this.loggedIn;
  }
}
