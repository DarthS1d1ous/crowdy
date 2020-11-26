export class User {
  constructor(public id: string,
              public username: string,
              public login: string,
              public fullName: string,
              public createdAt: Date,
              public birthday: Date,
              public avatar: string) {
  }
}
