package com.ukrlegislation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ukrlegislation.entities.User;
import com.ukrlegislation.services.UserService;

import java.util.List;

/**
 * Created by dima on 7/18/15.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/",method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = "/user/{id}/",method = RequestMethod.GET)
    public User getUserById(@PathVariable long id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/user/",method = RequestMethod.PUT)
    public void addUser(@RequestBody User user) {
        userService.add(user);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.POST)
    public void updateUser(@PathVariable long id, @RequestBody User user) {
        user.setId(id);
        userService.update(user);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }

}
