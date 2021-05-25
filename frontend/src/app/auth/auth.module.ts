import {NgModule} from "@angular/core";
import {AuthComponent} from "./auth.component";
import {RouterModule, Routes} from "@angular/router";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MaterialModule} from "../shared/material/material.module";

const authRoutes: Routes = [
  {path: '', component: AuthComponent}
]

@NgModule({
  declarations: [
    AuthComponent,
  ],
  imports: [
    RouterModule.forChild(authRoutes),
    CommonModule,
    ReactiveFormsModule,
    MaterialModule,
    FormsModule
  ],
  exports: [
    AuthComponent
  ]
})
export class AuthModule {

}
