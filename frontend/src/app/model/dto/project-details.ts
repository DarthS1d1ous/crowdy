import {Project} from "../project.model";
import {User} from "../user.model";
import {Faq} from "../faq.model";
import {BackOption} from "../back-option.model";
import {Comment} from "../comment";

export class ProjectDetails extends Project {
  constructor(id: string,
              name: string,
              description: string,
              createdAt: Date,
              deadline: Date,
              imageUrls: string[],
              overallBack: number,
              currentBack: number,
              likes: User[],
              author: User,
              public comments: Comment[],
              public faqs: Faq[],
              public backOptions: BackOption[]) {
    super(id, name, description, createdAt, deadline, imageUrls, overallBack, currentBack, likes, author);
  }
}
