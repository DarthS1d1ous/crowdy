import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../models/category";
import {Project} from "../models/project";
import {Faq} from "../models/faq";
import {Comment} from "../models/comment";
import {CommentSave} from "../models/dto/comment-save";
import {Backoption} from "../models/backoption";

@Injectable()
export class ProjectService {

  constructor(public httpClient: HttpClient) {
  }

  public getAllCategories(): Observable<Category[]> {
    return this.httpClient.get<Category[]>("http://localhost:8082/categories");
  }

  public getProjectById(id: number): Observable<Project> {
    return this.httpClient.get<Project>("http://localhost:8082/projects/" + id);
  }

  getFaqsByProjectId(projectId: string) {
    return this.httpClient.get<Faq[]>("http://localhost:8082/faqs/project/" + projectId)
  }

  getCommentsByProjectId(projectId: string) {
    return this.httpClient.get<Comment[]>("http://localhost:8082/comments/project/" + projectId);
  }

  sendComment(commentSave: CommentSave) {
    return this.httpClient.post<Comment>("http://localhost:8082/comments", commentSave);
  }

  getBackoptionsByProjectId(projectId: string) {
    return this.httpClient.get<Backoption[]>("http://localhost:8082/backoptions/project/" + projectId);
  }
}
