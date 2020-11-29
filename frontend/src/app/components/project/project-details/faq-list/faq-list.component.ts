import {Component, Input, OnInit} from '@angular/core';
import {ProjectService} from "../../../../services/project.service";
import {Faq} from "../../../../models/faq";

@Component({
  selector: 'app-faq-list',
  templateUrl: './faq-list.component.html',
  styleUrls: ['./faq-list.component.css']
})
export class FaqListComponent implements OnInit {
  @Input()
  projectId: string;
  faqs: Faq[];

  constructor(private projectService: ProjectService) {
  }

  ngOnInit(): void {
    this.projectService.getFaqsByProjectId(this.projectId)
      .subscribe(faqs => this.faqs = faqs)
  }

}
