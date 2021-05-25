import {User} from "./user.model";

export class Project {
  constructor(public id: string,
              public name: string,
              public description: string,
              public createdAt: Date,
              public deadline: Date,
              public imageUrls: string[],
              public overallBack: number,
              public currentBack: number,
              public likes: User[],
              public author: User) {
  }
}
