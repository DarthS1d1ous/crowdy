import {Project} from "./project";
import {User} from "./user";

export class UserProfile {
  constructor(public id: string,
              public username: string,
              public fullName: string,
              public createdAt: Date,
              public birthday: Date,
              public avatar: string,
              public projects: Project[],
              public followers: User[],
              public following: User[]) {
  }
}
