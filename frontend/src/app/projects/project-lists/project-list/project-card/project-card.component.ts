import {Component, Input, OnInit} from '@angular/core';
import {Project} from "../../../../model/project.model";
import {Store} from "@ngrx/store";
import * as fromApp from "../../../../store/app.reducer";
import * as ProjectsActions from '../../../store/project.actions';
import {ProjectLike} from "../../../../model/dto/project-like";
import {User} from "../../../../model/user.model";
import {MatDialog} from "@angular/material/dialog";
import {LoginDialogComponent} from "../../../../shared/dialog/login-dialog.component";

@Component({
  selector: 'app-project-card',
  templateUrl: './project-card.component.html',
  styleUrls: ['./project-card.component.css'],
})
export class ProjectCardComponent implements OnInit {
  @Input() project!: Project;
  isLikedByCurrentUser: boolean = false;
  date = new Date().toDateString();
  slides = [1, 2, 3, 4, 5];
  isProjectLikedByUser: boolean = false;
  currentUser!: User;
  projectLikeCount!: number;

  constructor(private store: Store<fromApp.AppState>,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.projectLikeCount = this.project.likes.length;
    this.currentUser = JSON.parse(localStorage.getItem("userData")!);
    if (this.currentUser) {
      this.isProjectLikedByUser = !!this.project.likes.find(value => value.id == this.currentUser.id);
    }
  }

  likeProject(): void {
    if (this.currentUser) {
      if (this.isProjectLikedByUser) {
        this.store.dispatch(new ProjectsActions.DeleteProjectLike(new ProjectLike(this.currentUser.id, this.project.id)));
        this.projectLikeCount--;
      } else {
        this.store.dispatch(new ProjectsActions.SaveProjectLike(new ProjectLike(this.currentUser.id, this.project.id)));
        this.projectLikeCount++;
      }
      this.isProjectLikedByUser = !this.isProjectLikedByUser;
    } else {
      this.dialog.open(LoginDialogComponent);
    }
  }
}
