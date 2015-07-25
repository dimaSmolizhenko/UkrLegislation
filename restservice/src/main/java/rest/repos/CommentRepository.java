package rest.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rest.entities.Comment;

/**
 * Created by dima on 7/25/15.
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
