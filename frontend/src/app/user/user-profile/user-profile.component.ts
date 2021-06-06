import {Component, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import * as fromApp from "../../store/app.reducer";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private store: Store<fromApp.AppState>) {
  }

  ngOnInit(): void {
    // this.store.dispatch(new UserActions.FetchVisitUser())
  }

}
