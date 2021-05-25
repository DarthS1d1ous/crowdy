import * as AuthActions from './auth.actions';
import {User} from "../../model/user.model";

export interface State {
  user: User;
  authError: string;
  loading: boolean;
}

const initialState: State = {
  user: null as any,
  authError: null as any,
  loading: false
};

export function authReducer(state = initialState, action: AuthActions.AuthActions): State {
  console.log('authReducer action:' + action.type);
  switch (action.type) {
    case AuthActions.AUTHENTICATE_SUCCESS:
      console.log('AuthActions.AUTHENTICATE_SUCCESS');
      return {
        ...state,
        user: action.payload.user,
        authError: null as any,
        loading: false
      };
    case AuthActions.LOGOUT:
      console.log('AuthActions.LOGOUT');
      return {
        ...state,
        authError: null as any,
        user: null as any
      };
    case AuthActions.LOGIN_START:
      console.log('AuthActions.LOGIN_START');
      return {
        ...state,
        authError: null as any,
        loading: true
      };
    case AuthActions.SIGNUP_START:
      console.log('AuthActions.SIGNUP_START');
      return {
        ...state,
        authError: null as any,
        loading: true
      };
    case AuthActions.AUTHENTICATE_FAIL:
      console.log('AuthActions.AUTHENTICATE_FAIL');
      return {
        ...state,
        user: null as any,
        authError: action.payload,
        loading: false
      };
    case AuthActions.CLEAR_ERROR:
      console.log('AuthActions.CLEAR_ERROR');
      return {
        ...state,
        authError: null as any
      };
    default:
      return state;
  }
}
