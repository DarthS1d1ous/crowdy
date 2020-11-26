import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../../models/user";

@Component({
  selector: 'app-project-like-tooltip',
  templateUrl: './project-like-tooltip.component.html',
  styleUrls: ['./project-like-tooltip.component.css']
})
export class ProjectLikeTooltipComponent implements OnInit {

  @Input()
  likes: User[];

  constructor() {
  }

  ngOnInit(): void {
  }

}
