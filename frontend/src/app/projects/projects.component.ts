import {Component, OnDestroy, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import * as fromApp from "../store/app.reducer"
import * as ProjectsActions from './store/project.actions';
import * as UserActions from '../user/store/user.actions';
import {Category} from "../model/category";
import {Subscription} from "rxjs";
import {User} from "../model/user.model";

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit, OnDestroy {
  allCategories!: Category[];
  storeSubscription!: Subscription;
  currentUser!: User;

  constructor(private store: Store<fromApp.AppState>) {
  }

  ngOnInit(): void {
    this.currentUser = JSON.parse(localStorage.getItem('userData')!);
    if (this.currentUser) {
      this.store.dispatch(new UserActions.FetchCurrentUser(this.currentUser.id));
    }
    this.store.dispatch(new ProjectsActions.FetchAllCategories());
    this.storeSubscription = this.store.select('project').subscribe(projectsState => {
      console.log("select [ropject after like")
      this.allCategories = projectsState.categories;
    })
  }

  ngOnDestroy(): void {
    this.storeSubscription.unsubscribe();
  }

  getCategoriesForNavBar(): Category[] {
    return this.allCategories.slice().sort((a, b) =>
      a.projects.length < b.projects.length
        ? 1
        : a.projects.length > b.projects.length
        ? -1
        : 0)
      .slice(0, 7);
  }

}
