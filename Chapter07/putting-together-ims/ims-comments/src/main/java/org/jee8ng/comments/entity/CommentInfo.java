package org.jee8ng.comments.entity;

/**
 *
 * @author prashantp.org
 */
public class CommentInfo {
    private Comment comment;
    private String byUserName;
    
    public CommentInfo() {
    }
    
    public CommentInfo(Comment c) {
        this.comment = c;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getByUserName() {
        return byUserName;
    }

    public void setByUserName(String byUserName) {
        this.byUserName = byUserName;
    }
    
    
}
