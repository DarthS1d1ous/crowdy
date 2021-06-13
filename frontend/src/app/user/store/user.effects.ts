import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {Store} from "@ngrx/store";
import * as fromApp from '../../store/app.reducer';
import {HttpClient} from "@angular/common/http";
import * as UserActions from "./user.actions";
import {map, switchMap} from "rxjs/operators";
import {UserProfile} from "../../model/dto/user-profile";

@Injectable()
export class UserEffects {
  fetchVisitUser = createEffect((): any => this.actions$.pipe(
    ofType(UserActions.FETCH_VISIT_USER),
    switchMap((data: UserActions.FetchVisitUser) =>
      this.http.get<UserProfile>(`http://localhost:8081/userProfiles/${data.payload}`)),
    map((userProfile: UserProfile) => {
      return new UserActions.SetVisitUser(userProfile);
    })
  ));

  fetchCurrentUser = createEffect((): any => this.actions$.pipe(
    ofType(UserActions.FETCH_CURRENT_USER),
    switchMap((data: UserActions.FetchVisitUser) =>
      this.http.get<UserProfile>(`http://localhost:8081/userProfiles/${data.payload}`)),
    map((userProfile: UserProfile) => {
      return new UserActions.SetCurrentUser(userProfile);
    })
  ));

  followUser = createEffect((): any => this.actions$.pipe(
    ofType(UserActions.FOLLOW_USER),
    switchMap((data: UserActions.FollowUser) => {
      return this.http.post<UserProfile>(
        `http://localhost:8081/users/follow/users`,
        {
          followerUserId: data.payload.followerUserId,
          followingUserId: data.payload.followingUserId
        })
        .pipe(
          map(resData => new UserActions.SetFollowUser(resData))
        )
    })
  ));

  unfollowUser = createEffect((): any => this.actions$.pipe(
    ofType(UserActions.UNFOLLOW_USER),
    switchMap((data: UserActions.UnfollowUser) => {
      return this.http.delete<UserProfile>(
        `http://localhost:8081/users/${data.payload.followerId}/follow/users/${data.payload.followingId}`
      )
        .pipe(
          map(resData => new UserActions.SetUnfollowUser(resData))
        )
    })
  ));
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
