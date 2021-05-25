import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MaterialModule} from "../shared/material/material.module";
import {ProjectsComponent} from "./projects.component";
import {ProjectCardComponent} from "./project-lists/project-list/project-card/project-card.component";
import {ProjectDetailComponent} from "./project-detail/project-detail.component";
import {ProjectListComponent} from "./project-lists/project-list/project-list.component";
import {ProjectListsComponent} from "./project-lists/project-lists.component";
import {ProjectsRoutingModule} from "./projects-routing.module";
import {SwiperModule} from "swiper/angular";
import {ProjectSearchComponent} from './project-search/project-search.component';

@NgModule({
  declarations: [
    ProjectsComponent,
    ProjectCardComponent,
    ProjectDetailComponent,
    ProjectListComponent,
    ProjectListsComponent,
    ProjectSearchComponent,
  ],
  imports: [
    CommonModule,
    ProjectsRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
    FormsModule,
    SwiperModule
  ],
  exports: [
    ProjectsComponent
  ]
})
export class ProjectsModule {

}
