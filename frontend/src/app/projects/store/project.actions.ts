import {Action} from "@ngrx/store";
import {Category} from "../../model/category";
import {ProjectLike} from "../../model/dto/project-like";
import {ProjectDetails} from "../../model/dto/project-details";
import {CommentSaveRequest} from "../../model/request/comment-save-request";
import {Comment} from "../../model/comment";

export const FETCH_ALL_CATEGORIES = '[Projects] Fetch All Categories';
export const SET_ALL_CATEGORIES = '[Projects] Set All Categories';
export const SAVE_PROJECT_LIKE = '[Projects] Save Project Like';
export const DELETE_PROJECT_LIKE = '[Projects] Delete Project Like';
export const FETCH_PROJECT_DETAIL = '[Projects] Fetch Project Detail ';
export const SET_PROJECT_DETAIL = '[Projects] Set Project Detail';
export const SAVE_PROJECT_COMMENT = '[Projects] Save Project Comment';
export const ADD_PROJECT_COMMENT = '[Projects] Add Project Comment';
export const FETCH_PROJECT_COMMENTS = '[Projects] Fetch Project Comments';
export const SET_PROJECT_COMMENTS = '[Projects] Set Project Comments';

export class FetchAllCategories implements Action {
  readonly type = FETCH_ALL_CATEGORIES;
}

export class SetAllCategories implements Action {
  readonly type = SET_ALL_CATEGORIES;

  constructor(public payload: Category[]) {
  }
}

export class SaveProjectLike implements Action {
  readonly type = SAVE_PROJECT_LIKE;

  constructor(public payload: ProjectLike) {
  }
}

export class DeleteProjectLike implements Action {
  readonly type = DELETE_PROJECT_LIKE;

  constructor(public payload: ProjectLike) {
  }
}

export class FetchProjectDetail implements Action {
  readonly type = FETCH_PROJECT_DETAIL;

  constructor(public payload: string) {
  }
}

export class SetProjectDetail implements Action {
  readonly type = SET_PROJECT_DETAIL;

  constructor(public payload: ProjectDetails) {
  }
}

export class SaveProjectComment implements Action {
  readonly type = SAVE_PROJECT_COMMENT;

  constructor(public payload: CommentSaveRequest) {
  }
}

export class AddProjectComment implements Action {
  readonly type = ADD_PROJECT_COMMENT;

  constructor(public payload: Comment) {
  }
}

export class FetchProjectComments implements Action {
  readonly type = FETCH_PROJECT_COMMENTS;

  constructor(public payload: string) {
  }
}

export class SetProjectComments implements Action {
  readonly type = SET_PROJECT_COMMENTS;

  constructor(public payload: Comment[]) {
  }
}

export type ProjectsActions = FetchAllCategories | SetAllCategories | SaveProjectLike
  | DeleteProjectLike | FetchProjectDetail | SetProjectDetail | SaveProjectComment
  | AddProjectComment | FetchProjectComments | SetProjectComments;

