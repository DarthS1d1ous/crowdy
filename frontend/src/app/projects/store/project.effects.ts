import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {Store} from "@ngrx/store";
import * as fromApp from '../../store/app.reducer';
import * as ProjectsActions from './project.actions';
import {map, switchMap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Category} from "../../model/category";

@Injectable()
export class ProjectEffects {
  fetchAllCategories = createEffect((): any => this.actions$.pipe(
    ofType(ProjectsActions.FETCH_ALL_CATEGORIES),
    switchMap(() => this.http.get<Category[]>('http://localhost:8082/categories')),
    map(categories => {
      console.log(categories);
      return new ProjectsActions.SetAllCategories(categories);
    })
  ));

  constructor(private actions$: Actions,
              private store: Store<fromApp.AppState>,
              private http: HttpClient) {
  }
}
