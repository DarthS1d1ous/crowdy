import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProjectListComponent} from './project-list/project-list.component';
import {ProjectItemComponent} from './project-list/project-item/project-item.component';
import {ProjectDetailsComponent} from './project-details/project-details.component';
import {MaterialModule} from "../../material/material.module";
import {ProjectService} from "../../services/project.service";
import {RouteModule} from "../../route/route.module";
import {BackoptionListComponent} from './project-details/backoption-list/backoption-list.component';
import {FaqListComponent} from './project-details/faq-list/faq-list.component';
import {CommentListComponent} from './project-details/comment-list/comment-list.component';
import {BackoptionItemComponent} from './project-details/backoption-list/backoption-item/backoption-item.component';
import {CommentItemComponent} from './project-details/comment-list/comment-item/comment-item.component';
import {FaqItemComponent} from './project-details/faq-list/faq-item/faq-item.component';
import {ReactiveFormsModule} from "@angular/forms";
import {ProjectAddComponent} from './project-add/project-add.component';
import {UserModule} from "../user/user.module";


@NgModule({
  declarations: [
    ProjectListComponent,
    ProjectItemComponent,
    ProjectDetailsComponent,
    BackoptionListComponent,
    FaqListComponent,
    CommentListComponent,
    BackoptionItemComponent,
    CommentItemComponent,
    FaqItemComponent,
    ProjectAddComponent
  ],
  exports: [
    ProjectItemComponent,
  ],
  imports: [
    CommonModule,
    MaterialModule,
    RouteModule,
    ReactiveFormsModule,
    UserModule
  ],
  providers: [
    ProjectService
  ]
})
export class ProjectModule {
}
