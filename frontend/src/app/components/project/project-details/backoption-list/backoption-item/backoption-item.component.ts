import {Component, Input, OnInit} from '@angular/core';
import {Backoption} from "../../../../../models/backoption";

@Component({
  selector: 'app-backoption-item',
  templateUrl: './backoption-item.component.html',
  styleUrls: ['./backoption-item.component.css']
})
export class BackoptionItemComponent implements OnInit {
  @Input()
  backoption: Backoption;
  @Input()
  projectId: string;

  constructor() {
  }

  ngOnInit(): void {
  }

}
