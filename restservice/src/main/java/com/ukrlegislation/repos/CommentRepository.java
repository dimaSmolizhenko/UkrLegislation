package com.ukrlegislation.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ukrlegislation.entities.Comment;

/**
 * Created by dima on 7/25/15.
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
