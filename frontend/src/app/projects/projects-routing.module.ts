import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ProjectsComponent} from "./projects.component";
import {ProjectSearchComponent} from "./project-search/project-search.component";
import {ProjectDetailsComponent} from "./project-details/project-details.component";
import {ProjectCreateComponent} from "./project-create/project-create.component";
import {ProjectPaymentComponent} from "./project-payment/project-payment.component";

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
  {path: 'projects/:id', component: ProjectDetailsComponent},
  {path: 'create', component: ProjectCreateComponent},
  {path: 'projects/:id/payment', component: ProjectPaymentComponent}
];

@NgModule({
  imports: [
    RouterModule.forChild(projectsRoutes)
  ],
  exports: [RouterModule]
})
export class ProjectsRoutingModule {
}
