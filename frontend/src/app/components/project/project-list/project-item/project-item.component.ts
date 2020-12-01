import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../../../models/user";
import {Project} from "../../../../models/project";
import {AuthService} from "../../../../services/auth.service";

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

  constructor(public authService: AuthService) {
  }

  ngOnInit(): void {
    console.log(this.projectItem);
  }
}
