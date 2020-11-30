import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Route, RouterModule} from "@angular/router";
import {ProjectListComponent} from "../components/project/project-list/project-list.component";
import {LoginComponent} from "../components/login/login.component";
import {AuthGuardService} from "../services/auth-guard.service";
import {RegisterComponent} from "../components/register/register.component";
import {ProjectDetailsComponent} from "../components/project/project-details/project-details.component";
import {UserProfileComponent} from "../components/user/user-profile/user-profile.component";

const routes: Route[] = [
  {
    path: '', component: ProjectListComponent, pathMatch: 'full', canActivate: [AuthGuardService]
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'register', component: RegisterComponent
  },
  {
    path: 'projects/:id', component: ProjectDetailsComponent, canActivate: [AuthGuardService]
  },
  {
    path: 'users/:id', component: UserProfileComponent, canActivate: [AuthGuardService]
  }
  /*{path: 'recipes', component: RecipesComponent, children: [
      {path: 'new', component: RecipeEditComponent},
      {path: ':id', component: RecipeDetailComponent},
      {path: ':id/edit', component: RecipeEditComponent}
    ]},
  {path: 'shopping-list', component: ShoppingListComponent}*/
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule, RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class RouteModule {
}
