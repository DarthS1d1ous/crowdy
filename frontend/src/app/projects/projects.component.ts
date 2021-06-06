import {Component, OnDestroy, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import * as fromApp from "../store/app.reducer"
import * as ProjectsActions from './store/project.actions';
import {Category} from "../model/category";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit, OnDestroy {
  allCategories!: Category[];
  storeSubscription!: Subscription;

  constructor(private store: Store<fromApp.AppState>,

  ) {
  }

  ngOnInit(): void {
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
