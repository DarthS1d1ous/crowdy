import {Injectable} from "@angular/core";
import {Actions} from "@ngrx/effects";
import {Store} from "@ngrx/store";
import * as fromApp from '../../store/app.reducer';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class UserEffects {
  // fetchAllCategories = createEffect((): any => this.actions$.pipe(
  //   ofType(ProjectsActions.FETCH_ALL_CATEGORIES),
  //   switchMap(() => this.http.get<Category[]>('http://localhost:8082/categories')),
  //   map(categories => {
  //     console.log(categories);
  //     return new ProjectsActions.SetAllCategories(categories);
  //   })
  // ));
  //
  // saveProjectLike = createEffect((): any => this.actions$.pipe(
  //   ofType(ProjectsActions.SAVE_PROJECT_LIKE),
  //   switchMap((data: ProjectsActions.SaveProjectLike) => {
  //     console.log(data)
  //     return this.http.post<Project>(
  //       `http://localhost:8082/users/like/projects`, data.payload)
  //   })
  // ), {dispatch: false});
  //
  // deleteProjectLike = createEffect((): any => this.actions$.pipe(
  //   ofType(ProjectsActions.DELETE_PROJECT_LIKE),
  //   switchMap((data: ProjectsActions.SaveProjectLike) => {
  //     console.log(data)
  //     return this.http.delete<Project>(
  //       `http://localhost:8082/users/${data.payload.userId}/dislike/projects/${data.payload.projectId}`,
  //       {headers: new HttpHeaders({'Access-Control-Allow-Origin': '*'})})
  //   })
  // ), {dispatch: false});

  constructor(private actions$: Actions,
              private store: Store<fromApp.AppState>,
              private http: HttpClient) {
  }
}
