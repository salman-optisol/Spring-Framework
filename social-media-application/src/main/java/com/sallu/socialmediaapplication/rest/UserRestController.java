package com.sallu.socialmediaapplication.rest;

import com.sallu.socialmediaapplication.dao.UserDao;
import com.sallu.socialmediaapplication.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {
    UserDao userDao;
    @Autowired
    public UserRestController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{id}")
    public EntityModel<User> getUser(@PathVariable long id) {
        EntityModel<User> user = EntityModel.of(userDao.getUser(id));
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        user.add(linkBuilder.withRel("all-users"));

        return user;
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userDao.getUsers();
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        User createdUser = userDao.saveUser(user);

        URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(createdUser.getId())
                            .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userDao.deleteUser(id);
    }
}
