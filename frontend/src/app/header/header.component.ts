import {Component, OnInit} from '@angular/core';
import * as fromApp from '../store/app.reducer';
import {map} from 'rxjs/operators';
import * as AuthActions from '../auth/store/auth.actions';
import {Store} from "@ngrx/store";
import {Subscription} from "rxjs";
import {User} from "../model/user.model";
import * as UserActions from "../user/store/user.actions";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userSubscription!: Subscription;
  currentUser!: User;
  isAuthenticated = false;

  constructor(private store: Store<fromApp.AppState>) {
  }

  ngOnInit(): void {
    this.userSubscription = this.store.select('auth')
      .pipe(map(value => value.user))
      .subscribe(user => {
        this.currentUser = user;
        console.log(this.currentUser)
        this.isAuthenticated = !!user;
      });
  }

  onLogout(): void {
    this.store.dispatch(new UserActions.ClearCurrentUser())
    this.store.dispatch(new AuthActions.Logout());
  }

  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }

}
