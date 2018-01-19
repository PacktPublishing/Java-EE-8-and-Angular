package org.jee8ng.comments.boundary;

import java.time.LocalDateTime;
import java.util.Optional;
import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.equalTo;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jee8ng.comments.control.FindUserName;
import org.jee8ng.comments.entity.Comment;
import org.jee8ng.comments.entity.CommentInfo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

/**
 * Runs an Integration test which is for in-container testing
 *
 * @author prashantp.org
 */
@RunWith(Arquillian.class)
public class CommentsIntegrationTest {

    @Inject
    private CommentsService service;

    @Inject
    private FindUserName findUserName;

    /*
    * Sets up the in-container testing (resource and class files under test)
     */
    @Deployment
    public static WebArchive createDeployment() {        
        return ShrinkWrap.create(WebArchive.class, "ims-comments.war")
                .addClasses(CommentsService.class,
                        Comment.class,
                        CommentInfo.class,
                        FindUserName.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("web.xml")
                .addAsResource("persistence.xml",
                        "META-INF/persistence.xml");
    }

    @Before
    public void setupMock() {
        this.findUserName = mock(FindUserName.class);
        
        when(this.findUserName.getUserName(anyLong()))
                .thenReturn("prashant");
        //Explicitly set mocked FindUserName in CommentsService
        this.service.setFindUserName(this.findUserName);
    }

    @Test
    public void testAddComment() throws Exception {
        Comment comment = new Comment();
        comment.setByUser(11L);
        comment.setForIssue(200L);
        comment.setText("Test");
        comment.setCreated(LocalDateTime.now());
        this.service.add(comment);
        Optional<Comment> dbComment = this.service.get(comment.getId());

        assertTrue(dbComment.isPresent());
        assertThat(dbComment.get().getId(), equalTo(comment.getId()));
    }

    @Test
    public void testCommentInfoUpdatedByName() throws Exception {
        Comment comment = new Comment();
        comment.setByUser(11L);

        CommentInfo updatedInfo = this.service.updateName(new CommentInfo(comment));

        assertNotNull(updatedInfo);
        assertThat(updatedInfo.getByUserName(), equalTo("prashant"));
    }
}
