import {Action} from '@ngrx/store';
import {User} from "../../model/user.model";
import {UserRegister} from "../../model/dto/user-register";

export const LOGIN_START = '[Auth] Login start';
export const AUTHENTICATE_SUCCESS = '[Auth] Authenticate';
export const AUTHENTICATE_FAIL = '[Auth] Authenticate fail';
export const SIGNUP_START = '[Auth] Signup start';
export const CLEAR_ERROR = '[Auth] Clear error';
export const AUTO_LOGIN = '[Auth] Auto login';
export const LOGOUT = '[Auth] Logout';

export class AuthenticateSuccess implements Action {
  readonly type = AUTHENTICATE_SUCCESS;

  constructor(public payload: { user: User, redirect: boolean }) {
  }
}

export class Logout implements Action {
  readonly type = LOGOUT;
}

export class LoginStart implements Action {
  readonly type = LOGIN_START;

  constructor(public payload: { username: string, password: string }) {
  }
}

export class ClearError implements Action {
  readonly type = CLEAR_ERROR;
}

export class SignupStart implements Action {
  readonly type = SIGNUP_START;

  constructor(public payload: UserRegister) {
  }
}

export class AutoLogin implements Action {
  readonly type = AUTO_LOGIN;
}

export class AuthenticateFail implements Action {
  readonly type = AUTHENTICATE_FAIL;

  constructor(public payload: string) {
  }
}

export type AuthActions =
  AuthenticateSuccess
  | Logout
  | LoginStart
  | AuthenticateFail
  | SignupStart
  | ClearError
  | AutoLogin;

