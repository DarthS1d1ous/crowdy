import {Component, OnInit} from '@angular/core';
import {Project} from "../../../models/project";
import {ActivatedRoute} from "@angular/router";
import {ProjectService} from "../../../services/project.service";
import {UserService} from "../../../services/user.service";
import {map, mergeMap} from "rxjs/operators";

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css']
})
export class ProjectDetailsComponent implements OnInit {

  projectItem: Project;
  private isFollowing: boolean = false;

  constructor(private activatedRoute: ActivatedRoute, private projectService: ProjectService, private userService: UserService) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.pipe(
      mergeMap(params => this.projectService.getProjectById(params['id'])),
      mergeMap(project => {
        this.projectItem = project;
        return this.userService.isCurrentUserFollowing(this.projectItem.author)
      }),
      map(value => {
        console.log(value);
        return value;
      })
    ).subscribe(following => this.isFollowing = following);
  }

  isCurrentUserFollowingAuthor(): boolean {
    return this.isFollowing;
  }
}
