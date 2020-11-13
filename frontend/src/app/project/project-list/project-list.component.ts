import {Component, OnInit} from '@angular/core';
import {ProjectModel} from "../model/project.model";
import {ProjectService} from "../service/project.service";

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {

  public projects: ProjectModel[];

  constructor(private projectService: ProjectService) {
  }

  ngOnInit(): void {
    this.projectService.getAllProjects().subscribe(projects => this.projects = projects);
  }
}
