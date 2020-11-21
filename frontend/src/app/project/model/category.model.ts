import {ProjectModel} from "./project.model";

export class CategoryModel {
  constructor(public id: string,
              public name: string,
              public projects: ProjectModel[]) {
  }
}
