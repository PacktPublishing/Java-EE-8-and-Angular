/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jee8ng.ims.users.boundary;

import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import org.jee8ng.ims.users.entity.User;

/**
 *
 * @author prashantp
 */
@Stateless
public class UsersService {

    private static final List<User> list = Arrays.asList(
            new User(1L, "prashant"),
            new User(2L, "pallavi"),
            new User(3L, "tanisha"));

    public List<User> getAll() {
        return list;
    }

    public User getUser(Long id) {
        return list.get(0);
    }

    public Long add(User newUser) {
        return 4L;
    }

    public void updateIfExists(Long id,User existingUser) {
    }

    public void delete(Long id) {
    }

}
