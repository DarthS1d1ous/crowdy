import {Action} from "@ngrx/store";
import {UserProfile} from "../../model/dto/user-profile";

export const FETCH_VISIT_USER = '[User] Fetch Visit User';

export class FetchVisitUser implements Action {
  readonly type = FETCH_VISIT_USER;

  constructor(public payload: UserProfile) {

  }
}

export type UserActions = FetchVisitUser;

