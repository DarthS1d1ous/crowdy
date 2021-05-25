import {Project} from "../../model/project.model";
import * as ProjectActions from './project.actions';
import {Category} from "../../model/category";

export interface State {
  projects: Project[];
  categories: Category[];
}

const initialState: State = {
  projects: [],
  categories: [],
};

export function projectReducer(state = initialState, action: ProjectActions.ProjectsActions): State {
  switch (action.type) {
    case ProjectActions.SET_ALL_CATEGORIES:
      return {
        ...state,
        categories: action.payload,
      }
    default:
      return state;
  }
}
