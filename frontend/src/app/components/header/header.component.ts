import {Component, OnInit} from '@angular/core';
import {SignService} from "../../security/sign.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  showFiller = false;

  constructor(public signService: SignService) {
  }

  ngOnInit(): void {
  }

}
