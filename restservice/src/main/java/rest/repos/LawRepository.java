package rest.repos;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rest.entities.Law;

/**
 * Created by dima on 7/18/15.
 */
@Repository
public interface LawRepository extends CrudRepository<Law, Long> {

}
