import {User} from "../user.model";
import {Project} from "../project.model";
import {Role} from "../role.model";

export class UserProfile extends User {
  constructor(id: string,
              username: string,
              fullName: string,
              createdAt: Date,
              birthday: Date,
              avatar: string,
              roles: Role[],
              public followers: User[],
              public following: User[],
              public createdProjects: Project[],
              public backedProjects: Project[]) {
    super(id, username, fullName, createdAt, birthday, avatar, roles);
  }
}
