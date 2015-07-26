package com.ukrlegislation.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ukrlegislation.entities.User;

/**
 * Created by dima on 7/18/15.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
