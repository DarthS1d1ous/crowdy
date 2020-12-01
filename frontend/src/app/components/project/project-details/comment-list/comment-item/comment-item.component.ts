import {Component, Input, OnInit} from '@angular/core';
import {Comment} from "../../../../../models/comment";
import {AuthService} from "../../../../../services/auth.service";

@Component({
  selector: 'app-comment-item',
  templateUrl: './comment-item.component.html',
  styleUrls: ['./comment-item.component.css']
})
export class CommentItemComponent implements OnInit {
  @Input()
  comment: Comment;

  constructor(public authService: AuthService) {
  }

  ngOnInit(): void {
  }

}
