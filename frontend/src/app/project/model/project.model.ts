export class ProjectModel {
  constructor(public id: string,
              public name: string,
              public description: string,
              public createdAt: Date,
              public deadLine: Date,
              public imageUrls: string[],
              public overallBack: number,
              public currentBack: number) {
  }
}
