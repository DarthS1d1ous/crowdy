import {Component, Input, OnInit} from '@angular/core';
import {ProjectService} from "../../../../services/project.service";
import {Backoption} from "../../../../models/backoption";

@Component({
  selector: 'app-backoption-list',
  templateUrl: './backoption-list.component.html',
  styleUrls: ['./backoption-list.component.css']
})
export class BackoptionListComponent implements OnInit {
  @Input()
  projectId: string;
  backoptions: Backoption[];

  constructor(private projectsService: ProjectService) {
  }

  ngOnInit(): void {
    this.projectsService.getBackoptionsByProjectId(this.projectId)
      .subscribe(backoptions => this.backoptions = backoptions)
  }

}
