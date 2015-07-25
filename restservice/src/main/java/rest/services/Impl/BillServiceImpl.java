package rest.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entities.Bill;
import rest.repos.BillRepository;
import rest.services.BillService;

import java.util.List;

/**
 * Created by dima on 7/25/15.
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository repository;

    public List<Bill> getAll() {
        return (List<Bill>) repository.findAll();
    }

    public void add(Bill bill) {
        repository.save(bill);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public void getById(Long id) {
        repository.findOne(id);
    }

    public void getByName(String name) {

    }
}
