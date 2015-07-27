package com.ukrlegislation.services.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ukrlegislation.entities.User;
import com.ukrlegislation.repos.UserRepository;
import com.ukrlegislation.services.UserService;

import java.util.Date;
import java.util.List;

/**
 * Created by dima on 7/18/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }


    public void add(User user) {
        userRepository.save(user);
    }


    public void delete(Long id) {
        userRepository.delete(id);
    }


    public User getById(Long id) {
        return userRepository.findOne(id);
    }

    public void update(User entity) {
        //TODO
    }


    public void getByName(String name) {
        //TODO
    }


}
