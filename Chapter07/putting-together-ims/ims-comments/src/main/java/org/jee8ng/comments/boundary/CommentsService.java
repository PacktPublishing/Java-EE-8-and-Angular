package org.jee8ng.comments.boundary;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;
import org.jee8ng.comments.control.FindUserName;
import org.jee8ng.comments.entity.Comment;
import org.jee8ng.comments.entity.CommentInfo;

/**
 *
 * @author prashantp.org
 */
@Stateless
public class CommentsService {

    @PersistenceContext
    private EntityManager em;
    
    private FindUserName findUserName;
        
    @Inject
    public void setFindUserName(FindUserName userName) {
        this.findUserName = userName;
    }
    
    public FindUserName getFindUserName() {
        return this.findUserName;
    }

    public Set<CommentInfo> getAll(Long issueId) {
        List<Comment> list = em.createQuery("FROM Comment c WHERE c.forIssue = :id", Comment.class)
                .setParameter("id", issueId)
                .getResultList();

        return list.parallelStream().map(CommentInfo::new)
                .map(this::updateName)
                .collect(Collectors.toSet());
    }
    
    public Optional<Comment> get(Long id) {
        Comment found = em.find(Comment.class, id);
        return found != null ? Optional.of(found) : Optional.empty();
    }

    public void add(@Valid Comment newComment) {
        em.persist(newComment);
    }

    public void remove(Long id) {
        Query query = em.createQuery("DELETE FROM Comment i WHERE i.id = :id");
        query.setParameter("id", id)
                .executeUpdate();
    }

    public CommentInfo updateName(CommentInfo info) {
        String name = this.findUserName.getUserName(info.getComment().getByUser());
        info.setByUserName(name);
        return info;
    }

//    private static String getUserName(Long byUser) {
//        Client client = ClientBuilder.newBuilder()
//                .connectTimeout(500, TimeUnit.MICROSECONDS)
//                .readTimeout(700, TimeUnit.MICROSECONDS)
//                .build();
//        try {
//            JsonObject userJson = client.target("http://ims-users:8080/ims-users/resources/users/{id}")
//                    .resolveTemplate("id", byUser)
//                    .request().get(JsonObject.class);
//            System.out.println("found json " + userJson);
//            return userJson.getString("name");
//        } catch (ProcessingException pe) {
//            pe.printStackTrace();
//            return "";
//        }
//    }

}
