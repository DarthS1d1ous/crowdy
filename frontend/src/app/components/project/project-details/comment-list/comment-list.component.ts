import {Component, Input, OnInit} from '@angular/core';
import {ProjectService} from "../../../../services/project.service";
import {Comment} from "../../../../models/comment";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CommentSave} from "../../../../models/dto/comment-save";
import {AuthService} from "../../../../services/auth.service";

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {
  @Input()
  projectId: string;
  comments: Comment[];
  sendCommentForm: FormGroup;

  constructor(
    private projectService: ProjectService,
    private fb: FormBuilder,
    private authService: AuthService
  ) {
    this.sendCommentForm = this.fb.group({
      comment: ['', Validators.minLength(1)]
    });
  }

  ngOnInit(): void {
    this.projectService.getCommentsByProjectId(this.projectId)
      .subscribe(comments => {
        this.comments = comments;
        this.comments.sort((a, b) => {
          let d1 = new Date(a.createdAt);
          let d2 = new Date(b.createdAt);
          let same = d1.getTime() === d2.getTime();
          if (same) return 0;
          if (d1 > d2) return 1;
          if (d1 < d2) return -1;
        });
      });
  }

  onCommentSend() {
    const comment = this.sendCommentForm.get('comment').value;
    this.projectService.sendComment(new CommentSave(comment, this.authService.getCurrentUser().id, this.projectId))
      .subscribe(comment => this.comments.push(comment))
  }

  public trackItem(index: number, comment: Comment) {
    return comment.id;
  }
}
