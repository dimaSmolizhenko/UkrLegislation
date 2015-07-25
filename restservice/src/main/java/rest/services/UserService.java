package rest.services;


import rest.entities.User;

import java.util.List;

/**
 * Created by dima on 7/18/15.
 */
public interface UserService {

    public List<User> getAll();

    public void add(User user);

    public void delete(Long id);

    public void getById(Long id);

    public void getByName(String name);

}
