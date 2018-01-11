/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.comments.entity;

/**
 *
 * @author prashantp
 */
public class CommentInfo {
    private Comment comment;
    private String byUserName;
    
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
