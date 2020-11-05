import {Component, OnInit} from '@angular/core';
import {ProjectModel} from "../model/project.model";
import {Observable} from "rxjs";
import {ProjectService} from "../service/project.service";

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {

  private projects: Observable<ProjectModel[]>;

  constructor(private projectService: ProjectService) {
  }

  ngOnInit(): void {
    this.projects = this.projectService.getAllProjects();
  }

  public getProjects(): Observable<ProjectModel[]> {
    return this.projects;
  }
}
