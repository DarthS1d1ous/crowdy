import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {Store} from "@ngrx/store";
import * as fromApp from '../../store/app.reducer';
import * as ProjectsActions from './project.actions';
import {map, switchMap} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Category} from "../../model/category";
import {Project} from "../../model/project.model";
import {ProjectDetails} from "../../model/dto/project-details";
import {Comment} from "../../model/comment";

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

  saveProjectLike = createEffect((): any => this.actions$.pipe(
    ofType(ProjectsActions.SAVE_PROJECT_LIKE),
    switchMap((data: ProjectsActions.SaveProjectLike) => {
      console.log(data)
      return this.http.post<Project>(
        `http://localhost:8082/users/like/projects`, data.payload)
    })
  ), {dispatch: false});

  deleteProjectLike = createEffect((): any => this.actions$.pipe(
    ofType(ProjectsActions.DELETE_PROJECT_LIKE),
    switchMap((data: ProjectsActions.SaveProjectLike) => {
      console.log(data)
      return this.http.delete<Project>(
        `http://localhost:8082/users/${data.payload.userId}/dislike/projects/${data.payload.projectId}`,
        {headers: new HttpHeaders({'Access-Control-Allow-Origin': '*'})})
    })
  ), {dispatch: false});

  fetchProjectDetail = createEffect((): any => this.actions$.pipe(
    ofType(ProjectsActions.FETCH_PROJECT_DETAIL),
    switchMap((data: ProjectsActions.FetchProjectDetail) =>
      this.http.get<ProjectDetails>(`http://localhost:8082/projectsDetails/${data.payload}`)),
    map(projectDetails => {
      console.log(projectDetails.createdAt)
      return new ProjectsActions.SetProjectDetail(projectDetails);
    })
  ));

  fetchProjectComments = createEffect((): any => this.actions$.pipe(
    ofType(ProjectsActions.FETCH_PROJECT_COMMENTS),
    switchMap((data: ProjectsActions.FetchProjectComments) =>
      this.http.get<Comment[]>(`http://localhost:8082/projects/${data.payload}/comments`)),
    map(comments => {
      return new ProjectsActions.SetProjectComments(comments);
    })
  ));

  saveProjectComment = createEffect((): any => this.actions$.pipe(
    ofType(ProjectsActions.SAVE_PROJECT_COMMENT),
    switchMap((data: ProjectsActions.SaveProjectComment) =>
      this.http.post<Comment>((`http://localhost:8082/comments`), data.payload)),
    map(comment => {
      return new ProjectsActions.AddProjectComment(comment);
    })
  ));


  constructor(private actions$: Actions,
              private store: Store<fromApp.AppState>,
              private http: HttpClient,) {
  }
}
