package rest.services.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entities.User;
import rest.repos.UserRepository;
import rest.services.UserService;

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


    public void getById(Long id) {
        userRepository.findOne(id);
    }


    public void getByName(String name) {

    }


}
