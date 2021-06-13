export class CommentSaveRequest {
  constructor(public comment: string,
              public projectId: string,
              public authorId: string) {
  }
}
