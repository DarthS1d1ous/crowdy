import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {UserProfileComponent} from "./user-profile/user-profile.component";

const userRoutes: Routes = [
  {path: ':id', component: UserProfileComponent},
];

@NgModule({
  imports: [
    RouterModule.forChild(userRoutes)
  ],
  exports: [RouterModule]
})
export class UserRoutingModule {
}
