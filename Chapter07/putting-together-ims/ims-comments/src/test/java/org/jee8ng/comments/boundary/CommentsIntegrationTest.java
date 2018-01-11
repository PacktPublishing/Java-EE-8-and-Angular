/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author prashantp
 */
@RunWith(Arquillian.class)
public class CommentsIntegrationTest {

    @Inject
    private CommentsService service;

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
        System.out.println("Mocking findUserName 1" + this.service.findUserName);
        this.service.findUserName = mock(FindUserName.class);
        System.out.println("Mocking findUserName 2" + this.service.findUserName);
        when(this.service.findUserName.getUserName(anyLong()))
                .thenReturn("prashant");
    }

    @Test
    public void testAddComment() throws Exception {
        Comment comment = new Comment();
        comment.setByUser(11L);
        comment.setForIssue(200L);
        comment.setText("Test");
        comment.setCreated(LocalDateTime.now());
        this.service.add(comment);
        System.out.println("commet added  " + comment);
        Optional<Comment> dbComment = this.service.get(comment.getId());

        assertTrue(dbComment.isPresent());
        assertThat(dbComment.get().getId(), equalTo(comment.getId()));
    }

    @Test
    public void testCommentInfoUpdatedByName() throws Exception {
//        Comment comment = new Comment();
//        comment.setByUser(11L);
//        System.out.println("Mocking findUserName 3" + this.service.findUserName);
//
//        CommentInfo updatedInfo = this.service.updateName(new CommentInfo(comment));
//        System.out.println("CommentInfo updated  " + updatedInfo);
//
//        assertNotNull(updatedInfo);
//        assertThat(updatedInfo.getByUserName(), equalTo("prashant"));
    }
}
