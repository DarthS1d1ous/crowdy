import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MaterialModule} from "../../material/material.module";
import {RouteModule} from "../../route/route.module";
import {ReactiveFormsModule} from "@angular/forms";
import {UserProfileComponent} from "./user-profile/user-profile.component";
import {UsersTooltipComponent} from "./users-tooltip/users-tooltip.component";


@NgModule({
  declarations: [
    UserProfileComponent,
    UsersTooltipComponent
  ],
  exports: [UsersTooltipComponent],
  imports: [
    CommonModule,
    MaterialModule,
    RouteModule,
    ReactiveFormsModule
  ],
  providers: []
})
export class UserModule {
}
