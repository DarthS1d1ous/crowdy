import {NgModule} from "@angular/core";
import {PreloadAllModules, RouterModule, Routes} from "@angular/router";

const appRoutes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  // {path: 'login', loadChildren: () => import('./auth/auth.module').then(value => value.AuthModule)}
]

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes, {preloadingStrategy: PreloadAllModules})
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
