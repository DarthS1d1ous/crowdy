import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../../models/user";

@Component({
  selector: 'app-users-tooltip',
  templateUrl: './users-tooltip.component.html',
  styleUrls: ['./users-tooltip.component.css']
})
export class UsersTooltipComponent implements OnInit {

  @Input()
  users: User[];
  @Input()
  message: string;

  constructor() {
  }

  ngOnInit(): void {
  }

}
