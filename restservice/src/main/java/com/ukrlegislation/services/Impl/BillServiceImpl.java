package com.ukrlegislation.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ukrlegislation.entities.Bill;
import com.ukrlegislation.repos.BillRepository;
import com.ukrlegislation.services.BillService;

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

    public Bill getById(Long id) {
        return  repository.findOne(id);
    }

    public void getByName(String name) {
        // TODO getByName
    }
}
