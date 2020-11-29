import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-backoption-list',
  templateUrl: './backoption-list.component.html',
  styleUrls: ['./backoption-list.component.css']
})
export class BackoptionListComponent implements OnInit {
  @Input()
  projectId: string;

  constructor() {
  }

  ngOnInit(): void {
  }

}
