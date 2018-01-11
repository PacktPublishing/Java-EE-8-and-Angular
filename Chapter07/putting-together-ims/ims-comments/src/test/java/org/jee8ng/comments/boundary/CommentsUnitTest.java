/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.comments.boundary;

import static org.hamcrest.CoreMatchers.equalTo;
import org.jee8ng.comments.control.FindUserName;
import org.jee8ng.comments.entity.Comment;
import org.jee8ng.comments.entity.CommentInfo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author prashantp
 */
public class CommentsUnitTest {
    CommentsService service;
    
    @Before
    public void setup() {
        this.service = new CommentsService();
        
        this.service.findUserName = mock(FindUserName.class);
        
        when(this.service.findUserName.getUserName(anyLong()))
                .thenReturn("prashant");
    }
    
    @Test
    public void testCommentInfoUpdatedByName() throws Exception {
        Comment comment = new Comment();
        comment.setByUser(11L);
        
        CommentInfo updatedInfo = service.updateName(new CommentInfo(comment));
        System.out.println("CommentInfo updated  " + updatedInfo);
        
        assertNotNull(updatedInfo);
        assertThat(updatedInfo.getByUserName(), equalTo("prashant"));
    }
}
