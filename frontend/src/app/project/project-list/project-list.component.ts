import {Component, OnInit} from '@angular/core';
import {ProjectService} from "../service/project.service";
import {CategoryModel} from "../model/category.model";

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {

  public categories: CategoryModel[];

  constructor(private projectService: ProjectService) {
  }

  ngOnInit(): void {
    this.projectService.getAllCategories().subscribe(categories => this.categories = categories);
  }
}
