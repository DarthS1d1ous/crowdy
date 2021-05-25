import {Component, Input, OnInit} from '@angular/core';
import {Category} from "../../model/category";

@Component({
  selector: 'app-project-lists',
  templateUrl: './project-lists.component.html',
  styleUrls: ['./project-lists.component.css']
})
export class ProjectListsComponent implements OnInit {
  @Input() allCategories!: Category[];

  constructor() {
  }

  ngOnInit(): void {
  }

}
