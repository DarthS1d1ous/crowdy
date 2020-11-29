import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProjectListComponent} from './project-list/project-list.component';
import {ProjectItemComponent} from './project-item/project-item.component';
import {ProjectDetailsComponent} from './project-details/project-details.component';
import {MaterialModule} from "../../material/material.module";
import {ProjectService} from "../../services/project.service";
import {ProjectLikeTooltipComponent} from './project-like-tooltip/project-like-tooltip.component';
import {RouteModule} from "../../route/route.module";
import {BackoptionListComponent} from './project-details/backoption-list/backoption-list.component';
import {FaqListComponent} from './project-details/faq-list/faq-list.component';
import {CommentListComponent} from './project-details/comment-list/comment-list.component';
import {BackoptionItemComponent} from './project-details/backoption-list/backoption-item/backoption-item.component';
import {CommentItemComponent} from './project-details/comment-list/comment-item/comment-item.component';
import {FaqItemComponent} from './project-details/faq-list/faq-item/faq-item.component';
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    ProjectListComponent,
    ProjectItemComponent,
    ProjectDetailsComponent,
    ProjectLikeTooltipComponent,
    BackoptionListComponent,
    FaqListComponent,
    CommentListComponent,
    BackoptionItemComponent,
    CommentItemComponent,
    FaqItemComponent
  ],
  exports: [
    ProjectItemComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    RouteModule,
    ReactiveFormsModule
  ],
  providers: [
    ProjectService
  ]
})
export class ProjectModule {
}
