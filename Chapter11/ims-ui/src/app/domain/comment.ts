export class Comment {
    byUser: number;
    forIssue: number;
    id: number;
    text: string;
}

export interface CommentInfo {
    byUserName: string;
    comment: Comment;
}