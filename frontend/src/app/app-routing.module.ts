import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';

const appRoutes: Routes = [
  {path: 'login', loadChildren: () => import('./auth/auth.module').then(value => value.AuthModule)},
  {path: '', loadChildren: () => import('./projects/projects.module').then(value => value.ProjectsModule)},
  {path: 'profile', loadChildren: () => import('./user/user.module').then(value => value.UserModule)}
]

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, {preloadingStrategy: PreloadAllModules, relativeLinkResolution: 'legacy'})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
