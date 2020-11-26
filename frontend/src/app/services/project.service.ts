import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Category} from "../models/category";

@Injectable()
export class ProjectService {

  constructor(public httpClient: HttpClient) {
  }

  public getAllCategories(): Observable<Category[]> {
    return this.httpClient.get<Category[]>("http://localhost:8082/categories");
  }
}
