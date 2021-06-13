import * as UserActions from './user.actions';
import {UserProfile} from "../../model/dto/user-profile";

export interface State {
  currentUser: UserProfile;
  visitUser: UserProfile;
}

const initialState: State = {
  currentUser: null as any,
  visitUser: null as any,
};

export function userReducer(state = initialState, action: UserActions.UserActions): State {
  console.log('userReducer action:' + action.type);
  switch (action.type) {
    case UserActions.SET_VISIT_USER:
      console.log(action.payload)
      return {
        ...state,
        visitUser: action.payload
      }
    case UserActions.SET_CURRENT_USER:
      console.log(action.payload)
      return {
        ...state,
        currentUser: action.payload
      }
    case UserActions.CLEAR_CURRENT_USER:
      return {
        ...state,
        currentUser: null as any,
      }
    case UserActions.SET_FOLLOW_USER:
      return {
        ...state,
        currentUser: action.payload
      }
    case UserActions.SET_UNFOLLOW_USER:
      return {
        ...state,
        currentUser: action.payload
      }
    //TODO govno cod
    case UserActions.UPDATE_PROFILE_AFTER_FOLLOW:
      let visitUpdated;
      let visitProfileUpdated;
      if (action.payload.visitIsCurrent) {
        if (action.payload.follow) {
          visitUpdated = [...state.visitUser.following, action.payload.followedUser]
        } else {
          visitUpdated = state.visitUser.following.filter(value => value.id !== action.payload.followedUser.id);
        }
        visitProfileUpdated = {
          ...state.visitUser,
          following: visitUpdated
        }
      } else {
        if (action.payload.follow) {
          visitUpdated = [...state.visitUser.followers, state.currentUser]
        } else {
          visitUpdated = state.visitUser.followers.filter(value => value.id !== state.currentUser.id);
        }
        visitProfileUpdated = {
          ...state.visitUser,
          followers: visitUpdated
        }
      }

      return {
        ...state,
        visitUser: visitProfileUpdated
      }
    default:
      return state;
  }
}
