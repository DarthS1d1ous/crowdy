import {MaterialModule} from "./material/material.module";
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {LoginDialogComponent} from "./dialog/login-dialog.component";

@NgModule({
  declarations: [
    LoginDialogComponent,
  ],
  imports: [MaterialModule, RouterModule],
  exports: [
    MaterialModule,
    LoginDialogComponent
  ],
})
export class SharedModule {
}
