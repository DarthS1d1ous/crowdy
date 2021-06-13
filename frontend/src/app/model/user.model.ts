import {Role} from "./role.model";

export class User {
  constructor(public id: string,
              public username: string,
              public fullName: string,
              public createdAt: Date,
              public birthday: Date,
              public avatar: string,
              public about: string,
              public roles: Role[]) {
  }
}
