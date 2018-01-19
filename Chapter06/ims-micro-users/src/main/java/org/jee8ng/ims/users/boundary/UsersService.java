package org.jee8ng.ims.users.boundary;

import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import org.jee8ng.ims.users.entity.User;

/**
 *
 * @author prashantp.org
 */
@Stateless
public class UsersService {
    //Dummy data
    private static final List<User> list = Arrays.asList(
            new User(1L, "prashant"),
            new User(2L, "pallavi"),
            new User(3L, "tanisha"));

    public List<User> getAll() {
        return list;
    }

    public User getUser(Long id) {
        //Hard code to return firt user id
        return list.get(0);
    }

    public Long add(User newUser) {
        //Dummy new user id
        return 4L;
    }

    public void updateIfExists(Long id,User existingUser) {
    }

    public void delete(Long id) {
    }

}
