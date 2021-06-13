import {Action} from "@ngrx/store";
import {UserProfile} from "../../model/dto/user-profile";
import {User} from "../../model/user.model";

export const FETCH_VISIT_USER = '[User] Fetch Visit User';
export const SET_VISIT_USER = '[User] Set Visit User';
export const FETCH_CURRENT_USER = '[User] Fetch Current User';
export const SET_CURRENT_USER = '[User] Set Current User';
export const CLEAR_CURRENT_USER = '[User] Clear Current User';
export const FOLLOW_USER = '[User] Follow User';
export const SET_FOLLOW_USER = '[User] Set Follow User';
export const SET_UNFOLLOW_USER = '[User] Set Unfollow User';
export const UNFOLLOW_USER = '[User] Unfollow User';
export const UPDATE_PROFILE_AFTER_FOLLOW = '[User] Update Profile After Follow';

export class FetchVisitUser implements Action {
  readonly type = FETCH_VISIT_USER;

  constructor(public payload: string) {

  }
}

export class SetVisitUser implements Action {
  readonly type = SET_VISIT_USER;

  constructor(public payload: UserProfile) {

  }
}

export class FetchCurrentUser implements Action {
  readonly type = FETCH_CURRENT_USER;

  constructor(public payload: string) {

  }
}

export class SetCurrentUser implements Action {
  readonly type = SET_CURRENT_USER;

  constructor(public payload: UserProfile) {

  }
}

export class ClearCurrentUser implements Action {
  readonly type = CLEAR_CURRENT_USER;

  constructor() {

  }
}

export class FollowUser implements Action {
  readonly type = FOLLOW_USER;

  constructor(public payload: { followerUserId: string, followingUserId: string }) {
  }
}

export class SetFollowUser implements Action {
  readonly type = SET_FOLLOW_USER;

  constructor(public payload: UserProfile) {
  }
}

export class UnfollowUser implements Action {
  readonly type = UNFOLLOW_USER;

  constructor(public payload: { followerId: string, followingId: string }) {
  }
}

export class SetUnfollowUser implements Action {
  readonly type = SET_UNFOLLOW_USER;

  constructor(public payload: UserProfile) {
  }
}

//TODO govno cod
export class UpdateProfileAfterFollow implements Action {
  readonly type = UPDATE_PROFILE_AFTER_FOLLOW;

  constructor(public payload: {
    followedUser: UserProfile | User, follow: boolean, visitIsCurrent: boolean
  }) {
  }
}

export type UserActions = FetchVisitUser
  | SetVisitUser
  | FollowUser
  | SetFollowUser
  | UnfollowUser
  | SetUnfollowUser
  | FetchCurrentUser
  | SetCurrentUser
  | ClearCurrentUser
  | UpdateProfileAfterFollow;

