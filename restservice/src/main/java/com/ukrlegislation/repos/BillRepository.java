package com.ukrlegislation.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ukrlegislation.entities.Bill;

/**
 * Created by dima on 7/25/15.
 */
@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
}
