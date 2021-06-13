import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import * as AuthActions from "./auth.actions";
import {catchError, map, switchMap, tap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {User} from "../../model/user.model";
import {of} from "rxjs";
import {AuthService} from "../auth.service";

const handleAuthentication = (resData: any) => {
  // const expirationDate = new Date(new Date().getTime() + +resData.expiresIn * 1000);
  const user = new User(
    resData.id,
    resData.username,
    resData.fullName,
    resData.createdAt,
    resData.birthday,
    resData.avatar,
    resData.about,
    resData.roles
  );
  localStorage.setItem('userData', JSON.stringify(user));
  console.log(user);
  return new AuthActions.AuthenticateSuccess({
    user,
    redirect: true,
  });
};

const handleError = (err: any) => {
  console.log(err)
  let errorMessage = 'An unknown error occurred';
  if (!err.error || !err.error.error) {
    return of(new AuthActions.AuthenticateFail(errorMessage));
  }
  switch (err.error.error.message) {
    case 'EMAIL_EXISTS':
      errorMessage = 'The email address is already in use by another account.';
      break;
    case 'EMAIL_NOT_FOUND':
      errorMessage = 'There is no user record corresponding to this identifier. The user may have been deleted.';
      break;
    case 'INVALID_PASSWORD':
      errorMessage = 'The password is invalid or the user does not have a password.';
      break;
  }
  return of(new AuthActions.AuthenticateFail(errorMessage));
};


@Injectable()
export class AuthEffects {
  authSignup = createEffect((): any => this.actions$.pipe(
    ofType(AuthActions.SIGNUP_START),
    switchMap((authData: AuthActions.SignupStart) => {
      console.log('authSignup effect');
      console.log(authData.payload)
      return this.http.post<User>('http://localhost:8081/register', authData.payload)
        .pipe(
          map(resData => {
              if (resData) {
                this.authService.setLogoutTimer(360000)
              }
              return handleAuthentication(resData);
            }
          ),
          catchError(err => {
            return handleError(err);
          })
        )
    })
  ));

  authLogin = createEffect((): any => this.actions$.pipe(
    ofType(AuthActions.LOGIN_START),
    switchMap((authData: AuthActions.LoginStart) => {
      console.log('authLogin effect');
      return this.http.post<User>(
        'http://localhost:8081/login',
        {
          username: authData.payload.username,
          password: authData.payload.password
        })
        .pipe(
          tap(x => console.log(x)),
          // tap(() => this.authService.setLogoutTimer(360000)),
          map(resData => {
            console.log(resData)
            console.log(12345)
            if (resData) {
              this.authService.setLogoutTimer(360000)
            }
            return handleAuthentication(resData);
          }),
          catchError(err => {
            console.log(err);
            console.log("asddf");
            return handleError(err);
          })
        );
    })
  ));

  autoLogin = createEffect((): any => this.actions$.pipe(
    ofType(AuthActions.AUTO_LOGIN),
    map(() => {
        console.log('autoLogin effect');
        const userData = JSON.parse(localStorage.getItem('userData')!);
        if (!userData) {
          return {type: 'DUMMY'};
        }
        const loadedUser = new User(
          userData.id,
          userData.username,
          userData.fullName,
          userData.createdAt,
          userData.birthday,
          userData.avatar,
          userData.about,
          userData.roles
        );
        if (loadedUser.username) {
          this.authService.setLogoutTimer(360000);
          return new AuthActions.AuthenticateSuccess({
            user: loadedUser,
            redirect: false,
          });
        }
        return {type: 'DUMMY'};
      }
    )
  ));

  autoLogout = createEffect((): any => this.actions$.pipe(
    ofType(AuthActions.LOGOUT),
    tap(() => {
      console.log('autoLogout effect');
      this.authService.clearLogoutTimer();
      localStorage.removeItem('userData');
      this.router.navigate(['/']);
    })
  ), {dispatch: false});

  authRedirect = createEffect((): any => this.actions$.pipe(
    ofType(AuthActions.AUTHENTICATE_SUCCESS),
    tap((authSuccessAction: AuthActions.AuthenticateSuccess) => {
      console.log('authRedirect effect');
      if (authSuccessAction.payload.redirect) {
        this.router.navigate(['/']);
      }
    })
  ), {dispatch: false});

  constructor(private actions$: Actions,
              private http: HttpClient,
              private router: Router,
              private authService: AuthService) {
  }
}
