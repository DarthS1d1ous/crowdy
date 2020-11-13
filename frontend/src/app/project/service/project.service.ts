import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ProjectModel} from "../model/project.model";
import {Observable} from "rxjs";

@Injectable()
export class ProjectService {

  constructor(public httpClient: HttpClient) {
  }

  public getAllProjects(): Observable<ProjectModel[]> {
    return this.httpClient.get<ProjectModel[]>("http://localhost:8082/projects");
  }
}
