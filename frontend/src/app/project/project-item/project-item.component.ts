import {Component, Input, OnInit} from '@angular/core';
import {ProjectModel} from "../model/project.model";
import {UserModel} from "../../user/model/user.model";

@Component({
  selector: 'app-project-item',
  templateUrl: './project-item.component.html',
  styleUrls: ['./project-item.component.css']
})
export class ProjectItemComponent implements OnInit {

  @Input()
  private projectItem: ProjectModel;
  @Input()
  private author: UserModel;

  constructor() {
  }

  ngOnInit(): void {
  }

  public getProjectItem(): ProjectModel {
    return this.projectItem;
  }

  public getAuthor(): UserModel {
    return this.author;
  }

}
