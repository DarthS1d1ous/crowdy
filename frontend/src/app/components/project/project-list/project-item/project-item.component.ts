import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../../../models/user";
import {Project} from "../../../../models/project";

@Component({
  selector: 'app-project-item',
  templateUrl: './project-item.component.html',
  styleUrls: ['./project-item.component.css'],
})
export class ProjectItemComponent implements OnInit {
  @Input()
  projectItem: Project;
  @Input()
  author: User;

  constructor() {
  }

  ngOnInit(): void {
    console.log(this.projectItem);
  }
}
