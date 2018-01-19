import { CommentInfo } from "./comment";
import { User } from "./user";

export class Issue {
    id: number;
    label: string;
    description: string;
    assignedTo: User;
    created: Date;
    comments?: CommentInfo[];
}
