package com.ukrlegislation.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ukrlegislation.entities.Deputy;
import com.ukrlegislation.repos.DeputyRepository;
import com.ukrlegislation.services.DeputyService;

import java.util.List;

/**
 * Created by dima on 7/25/15.
 */
@Service
public class DeputyServiceImpl implements DeputyService{

    @Autowired
    DeputyRepository deputyRepository;

    public List<Deputy> getAll() {
        return (List<Deputy>) deputyRepository.findAll();
    }

    public void add(Deputy deputy) {
        deputyRepository.save(deputy);
    }

    public void delete(Long id) {
        deputyRepository.delete(id);
    }

    public Deputy getById(Long id) {
        return deputyRepository.findOne(id);
    }

    public void update(Deputy entity) {
        //TODO
    }

    public void getByName(String name) {
        //TODO
    }
}
