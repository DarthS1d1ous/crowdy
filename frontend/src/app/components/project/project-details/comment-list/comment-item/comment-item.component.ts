import {Component, Input, OnInit} from '@angular/core';
import {Comment} from "../../../../../models/comment";
import {AuthService} from "../../../../../services/auth.service";
import {ProjectService} from "../../../../../services/project.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-comment-item',
  templateUrl: './comment-item.component.html',
  styleUrls: ['./comment-item.component.css']
})
export class CommentItemComponent implements OnInit {
  @Input()
  comment: Comment;
  commentEditing: boolean;
  commentEditForm: FormGroup;
  submitPerformed: boolean;

  constructor(public authService: AuthService, private projectService: ProjectService) {
    this.commentEditForm = new FormGroup({
      comment: new FormControl('', Validators.required),
    });
  }

  ngOnInit(): void {
  }

  onEdit() {
    this.commentEditing = true;
    this.commentEditForm.get('comment').setValue(this.comment.message);
  }

  onCommentEditSubmit() {
    this.submitPerformed = true;
    this.commentEditing = false;
    if(this.commentEditForm.valid && this.commentEditForm.get('comment').value !== this.comment.message) {
        this.projectService.updateComment({...this.comment, message: this.commentEditForm.get('comment').value})
          .subscribe(comment => this.comment.message = comment.message);
    }
  }
}
