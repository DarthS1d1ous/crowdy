import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ProjectsComponent} from "./projects.component";
import {ProjectSearchComponent} from "./project-search/project-search.component";

const projectsRoutes: Routes = [
  {
    path: '',
    component: ProjectsComponent,
    children: [
      // {path: 'search', component: ProjectSearchComponent},
      // {path: 'new', component: RecipeEditComponent},
      // {
      //   path: ':id', component: RecipeDetailComponent,
      //   // resolve: [RecipeResolverService]
      // },
      // {
      //   path: ':id/edit', component: RecipeEditComponent,
      //   // resolve: [RecipeResolverService]
      // }
    ]
  },
  {path: 'search', component: ProjectSearchComponent},
];

@NgModule({
  imports: [
    RouterModule.forChild(projectsRoutes)
  ],
  exports: [RouterModule]
})
export class ProjectsRoutingModule {
}
