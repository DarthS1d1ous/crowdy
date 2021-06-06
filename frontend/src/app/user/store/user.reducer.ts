import * as UserActions from './user.actions';
import {User} from "../../model/user.model";

export interface State {
  currentUser: User;
  visitUser: User;
}

const initialState: State = {
  currentUser: null as any,
  visitUser: null as any,
};

export function userReducer(state = initialState, action: UserActions.UserActions): State {
  switch (action.type) {

    default:
      return state;
  }
}
