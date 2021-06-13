import {MaterialModule} from "./material/material.module";
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {LoginDialogComponent} from "./dialog/login-dialog/login-dialog.component";
import {FollowDialogComponent} from './dialog/follow-dialog/follow-dialog.component';
import {CommonModule} from "@angular/common";

@NgModule({
  declarations: [
    LoginDialogComponent,
    FollowDialogComponent,
  ],
  imports: [MaterialModule, RouterModule, CommonModule],
  exports: [
    MaterialModule,
    LoginDialogComponent
  ],
})
export class SharedModule {
}
