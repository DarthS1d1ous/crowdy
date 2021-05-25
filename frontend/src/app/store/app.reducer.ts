import {ActionReducerMap} from "@ngrx/store";
import * as fromAuth from '../auth/store/auth.reducer';
import * as fromProject from '../projects/store/project.reducer';

export interface AppState {
  auth: fromAuth.State;
  project: fromProject.State;
}

export const appReducer: ActionReducerMap<AppState> = {
  auth: fromAuth.authReducer as any,
  project: fromProject.projectReducer as any,
};
