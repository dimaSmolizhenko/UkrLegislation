package com.ukrlegislation.service.impl;

import com.ukrlegislation.model.User;
import com.ukrlegislation.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ramax on 7/21/15.
 */
@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl() {
        users = new LinkedList<>();
        users.add(new User(1,"zccmj","password",new Date(),"role"));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
