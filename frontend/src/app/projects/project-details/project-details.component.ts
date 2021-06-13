import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import * as fromApp from "../../store/app.reducer";
import {Store} from "@ngrx/store";
import * as ProjectsActions from '../store/project.actions';
import {map, switchMap, tap} from "rxjs/operators";
import {ActivatedRoute, Params} from "@angular/router";
import {ProjectDetails} from "../../model/dto/project-details";
import SwiperCore, {Pagination} from "swiper/core";
import {FormControl} from "@angular/forms";
import {Comment} from "../../model/comment";
import {User} from "../../model/user.model";

SwiperCore.use([Pagination]);

@Component({
  selector: 'app-project-detail',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProjectDetailsComponent implements OnInit {

  projectDetails!: ProjectDetails;
  commentFormControl = new FormControl('');
  projectComments!: Comment[];
  currentUser!: User;


  constructor(private store: Store<fromApp.AppState>,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.currentUser = JSON.parse(localStorage.getItem('userData')!);

    this.route.params.pipe(
      map((params: Params) => {
        return params['id'];
      }),
      tap(id => {
        this.store.dispatch(new ProjectsActions.FetchProjectDetail(id))
        this.store.dispatch(new ProjectsActions.FetchProjectComments(id))
      }),
      switchMap(() => this.store.select('project')),
    ).subscribe(projectState => {
      this.projectDetails = projectState.projectDetails;
      this.projectComments = projectState.projectComments.slice().sort((a, b) => new Date(b.createdAt).getTime() - new Date(a.createdAt).getTime());
      console.log(this.projectDetails)
      console.log(this.projectComments)
    });
  }

  findDateToGo(): number {
    return (new Date(this.projectDetails?.deadline).getTime() - new Date(this.projectDetails?.createdAt).getTime()) / (1000 * 3600 * 24);
  }

  getProgressBarValue() {
    return this.projectDetails?.currentBack / this.projectDetails?.overallBack * 100;
  }

  saveComment() {
    this.store.dispatch(new ProjectsActions.SaveProjectComment({
      comment: this.commentFormControl.value,
      projectId: this.projectDetails.id,
      authorId: this.currentUser.id
    }))
  }

  noWhitespaceValidator(control: FormControl) {
    return (control.value || '').trim().length === 0;
  }
}
