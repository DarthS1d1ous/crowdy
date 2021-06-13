import {Project} from "../../model/project.model";
import * as ProjectActions from './project.actions';
import {Category} from "../../model/category";
import {ProjectDetails} from "../../model/dto/project-details";
import {Comment} from "../../model/comment";

export interface State {
  projectComments: Comment[];
  projectDetails: ProjectDetails;
  projects: Project[];
  categories: Category[];
}

const initialState: State = {
  projectComments: [],
  projectDetails: null as any,
  projects: [],
  categories: [],
};

export function projectReducer(state = initialState, action: ProjectActions.ProjectsActions): State {
  console.log('projectReducer action:' + action.type);
  switch (action.type) {
    case ProjectActions.SET_ALL_CATEGORIES:
      return {
        ...state,
        categories: action.payload,
      }
    case ProjectActions.SET_PROJECT_DETAIL:
      return {
        ...state,
        projectDetails: action.payload,
      }
    case ProjectActions.SET_PROJECT_COMMENTS:
      return {
        ...state,
        projectComments: action.payload,
      }
    case ProjectActions.ADD_PROJECT_COMMENT:
      return {
        ...state,
        projectComments: [...state.projectComments, action.payload]
      }
    default:
      return state;
  }
}
