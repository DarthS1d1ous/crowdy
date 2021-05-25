import {Injectable} from '@angular/core';
import * as fromApp from '../store/app.reducer';
import * as AuthActions from './store/auth.actions';
import {Store} from "@ngrx/store";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private tokenExpirationTimer: any;

  constructor(private store: Store<fromApp.AppState>) {
  }

  setLogoutTimer(expirationDate: number): void {
    this.tokenExpirationTimer = setTimeout(() => {
      this.store.dispatch(new AuthActions.Logout());
    }, expirationDate);
  }

  clearLogoutTimer(): void {
    if (this.tokenExpirationTimer) {
      clearTimeout(this.tokenExpirationTimer);
    }
    this.tokenExpirationTimer = null;
  }
}
