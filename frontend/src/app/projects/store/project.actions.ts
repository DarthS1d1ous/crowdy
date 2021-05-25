import {Action} from "@ngrx/store";
import {Project} from "../../model/project.model";
import {Category} from "../../model/category";

export const SET_PROJECTS = '[Projects] Set Projects';
export const FETCH_ProjectS = '[Projects] Fetch Projects';
export const FETCH_ALL_CATEGORIES = '[Projects] Fetch All Categories';
export const SET_ALL_CATEGORIES = '[Projects] Set All Categories';
export const STORE_ProjectS = '[Projects] Store Project';
export const ADD_Project = '[Projects] Add Project';
export const UPDATE_Project = '[Projects] Update Project';
export const DELETE_Project = '[Projects] Delete Project';

export class FetchAllCategories implements Action {
  readonly type = FETCH_ALL_CATEGORIES;
}

export class SetProjects implements Action {
  readonly type = SET_PROJECTS;

  constructor(public payload: Project[]) {
  }
}

export class SetAllCategories implements Action {
  readonly type = SET_ALL_CATEGORIES;

  constructor(public payload: Category[]) {
  }
}

// export class SetProjects implements Action {
//   readonly type = SET_ProjectS;
//
//   constructor(public payload: Project[]) {
//   }
// }
//
// export class FetchProjects implements Action {
//   readonly type = FETCH_ProjectS;
// }
//
// export class StoreProjects implements Action {
//   readonly type = STORE_ProjectS;
// }
//
//
// export class AddProject implements Action {
//   readonly type = ADD_Project;
//
//   constructor(public payload: Project) {
//   }
// }
//
// export class UpdateProject implements Action {
//   readonly type = UPDATE_Project;
//
//   constructor(public payload: { id: number; newProject: Project }) {
//   }
// }
//
// export class DeleteProject implements Action {
//   readonly type = DELETE_Project;
//
//   constructor(public payload: number) {
//   }
// }

export type ProjectsActions = FetchAllCategories | SetProjects | SetAllCategories
// SetProjects | AddProject | UpdateProject | DeleteProject | StoreProjects;

