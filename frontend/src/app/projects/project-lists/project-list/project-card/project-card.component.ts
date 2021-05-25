import {Component, Input, OnInit} from '@angular/core';
import {Project} from "../../../../model/project.model";

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

  constructor() {
  }

  ngOnInit(): void {
  }

  likeProject(): void {
    this.isLikedByCurrentUser = !this.isLikedByCurrentUser;
    console.log(this.isLikedByCurrentUser)
  }
}
