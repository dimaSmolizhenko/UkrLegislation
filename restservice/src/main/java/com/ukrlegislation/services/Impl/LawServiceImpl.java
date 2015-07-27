package com.ukrlegislation.services.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ukrlegislation.entities.Law;
import com.ukrlegislation.repos.LawRepository;
import com.ukrlegislation.services.LawService;

import java.util.List;

/**
 * Created by dima on 7/18/15.
 */
@Service
public class LawServiceImpl implements LawService {

    @Autowired
    LawRepository lawRepository;


    public List<Law> getAll() {
        return (List<Law>) lawRepository.findAll();
    }


    public void add(Law law) {
        lawRepository.save(law);
    }


    public void delete(Long id) {
        lawRepository.delete(id);
    }

    public Law getById(Long id) {
        return lawRepository.findOne(id);
    }

    public void update(Law entity) {
        //TODO
    }


    public void getByName(String name) {
        //TODO
    }
}
