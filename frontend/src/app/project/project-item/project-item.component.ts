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
  projectItem: ProjectModel;
  @Input()
  author: UserModel;

  constructor() {
  }

  ngOnInit(): void {
    console.log(this.projectItem);
  }
}
