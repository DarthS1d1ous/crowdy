import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ProjectsComponent} from "./projects.component";
import {ProjectCardComponent} from "./project-lists/project-list/project-card/project-card.component";
import {ProjectDetailsComponent} from "./project-details/project-details.component";
import {ProjectListComponent} from "./project-lists/project-list/project-list.component";
import {ProjectListsComponent} from "./project-lists/project-lists.component";
import {ProjectsRoutingModule} from "./projects-routing.module";
import {SwiperModule} from "swiper/angular";
import {ProjectSearchComponent} from './project-search/project-search.component';
import {SharedModule} from "../shared/shared.module";
import {ProjectCreateComponent} from './project-create/project-create.component';
import {ProjectPaymentComponent} from './project-payment/project-payment.component';

@NgModule({
  declarations: [
    ProjectsComponent,
    ProjectCardComponent,
    ProjectDetailsComponent,
    ProjectListComponent,
    ProjectListsComponent,
    ProjectSearchComponent,
    ProjectCreateComponent,
    ProjectPaymentComponent,
  ],
  imports: [
    CommonModule,
    ProjectsRoutingModule,
    ReactiveFormsModule,
    SharedModule,
    FormsModule,
    SwiperModule,
  ],
  exports: [
    ProjectsComponent
  ]
})
export class ProjectsModule {

}
