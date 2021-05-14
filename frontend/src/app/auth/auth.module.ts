import {NgModule} from "@angular/core";
import {AuthComponent} from "./auth.component";
import {RouterModule, Routes} from "@angular/router";

const authRoutes: Routes = [
  {path: 'login', component: AuthComponent}
]

@NgModule({
  declarations: [
    AuthComponent,
  ],
  imports: [
    RouterModule.forChild(authRoutes),
  ],
  exports: [
    AuthComponent
  ]
})
export class AuthModule {

}
