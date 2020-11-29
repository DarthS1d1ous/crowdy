import {User} from "./user";

export class Comment {
  constructor(public id: string,
              public author: User,
              public createdAt: Date,
              public message: string) {
  }
}
