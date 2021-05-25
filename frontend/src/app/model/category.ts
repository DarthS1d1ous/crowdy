import {Project} from "./project.model";

export class Category {
  constructor(public id: string,
              public name: string,
              public projects: Project[]) {
  }
}
