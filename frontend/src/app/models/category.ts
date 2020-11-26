import {Project} from "./project";

export class Category {
  constructor(public id: string,
              public name: string,
              public projects: Project[]) {
  }
}
