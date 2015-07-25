package rest.repos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import rest.entities.User;

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

    @Test
    public void show(){
            List<User> userList = (List<User>) userRepository.findAll();


        for(User user : userList){
            user.getFullName();
            System.out.println(user.getLogin());
        }

    }
}
