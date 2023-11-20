package com.sallu.socialmediaapplication.dao;

import com.sallu.socialmediaapplication.entity.User;
import com.sallu.socialmediaapplication.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public class UserDao {
    private static List<User> users;

    static {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public User saveUser(User user) {
        User createdUser = new User(user);
        users.add(createdUser);

        return createdUser;
    }

    public void deleteUser(long id) {
        Iterator<User> iterator = users.listIterator();
        while(iterator.hasNext()) {
            User user = iterator.next();
            if((user.getId()) == id) {
                users.remove(user);
                break;
            }
        }
    }

    public User getUser(long id) {
        Optional<User> user = users.stream().filter(curUser -> curUser.getId() == id).findAny();
        if(user.isPresent()) {
            return user.get();
        }
        else {
            throw new UserNotFoundException("Invalid user id");
        }
    }
}
