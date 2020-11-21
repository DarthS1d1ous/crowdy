import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CategoryModel} from "../model/category.model";

@Injectable()
export class ProjectService {

  constructor(public httpClient: HttpClient) {
  }

  public getAllCategories(): Observable<CategoryModel[]> {
    return this.httpClient.get<CategoryModel[]>("http://localhost:8082/categories");
  }
}
