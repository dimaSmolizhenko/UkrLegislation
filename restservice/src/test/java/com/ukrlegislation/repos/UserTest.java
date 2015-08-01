package com.ukrlegislation.repos;

import com.ukrlegislation.entities.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.ukrlegislation.entities.User;

import java.util.Date;
import java.util.List;

/**
 * Created by dima on 7/24/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:config/repo.xml")
@Transactional
public class UserTest {

    @Autowired
    UserRepository userRepository;

    private User user = new User();

    @Before
    public void addUsers(){

        user.setLogin("login");
        user.setPassword("pass");
        user.setFullName("qwertyu");
        user.setRegistrationDate(new Date());

        Role userRole = new Role();
        userRole.setId(1L);
        user.setRole(userRole);

        userRepository.save(user);
    }

    @Test
    public void show(){

        List<User> userList = (List<User>) userRepository.findAll();

        for(User user : userList){
            user.getFullName();
            System.out.println(user);
        }
    }

    @After
    public void deleteUser(){
        userRepository.delete(user);
    }
}
