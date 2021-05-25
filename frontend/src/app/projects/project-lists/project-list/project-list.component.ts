import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';
import SwiperCore, {A11y, Navigation, Scrollbar} from "swiper";
import {Category} from "../../../model/category";

SwiperCore.use([Navigation, Scrollbar, A11y]);

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProjectListComponent implements OnInit {
  @Input() category!: Category;

  constructor() {
  }

  ngOnInit(): void {
  }
}
