import {Component, OnInit} from '@angular/core';
import {ProjectService} from "../../../services/project.service";
import {Category} from "../../../models/category";

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {

  public categories: Category[];

  constructor(private projectService: ProjectService) {
  }

  ngOnInit(): void {
    this.projectService.getAllCategories().subscribe(categories => this.categories = categories);
  }
}
