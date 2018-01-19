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
 * Unit test
 * 
 * @author prashantp.org
 */
public class CommentsUnitTest {
    CommentsService service;
    
    @Before
    public void setup() {
        //No CDI used just POJO unit testing
        this.service = new CommentsService();
        
        this.service.setFindUserName(mock(FindUserName.class));
        
        when(this.service.getFindUserName().getUserName(anyLong()))
                .thenReturn("prashant");
    }
    
    @Test
    public void testCommentInfoUpdatedByName() throws Exception {
        Comment comment = new Comment();
        comment.setByUser(11L);
        //Test updateName which should return our Mock data
        CommentInfo updatedInfo = service.updateName(new CommentInfo(comment));
        
        assertNotNull(updatedInfo);
        assertThat(updatedInfo.getByUserName(), equalTo("prashant"));
    }
}
