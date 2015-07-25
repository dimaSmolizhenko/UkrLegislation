package rest.services.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entities.Law;
import rest.repos.LawRepository;
import rest.services.LawService;

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

    public void getById(Long id) {
        lawRepository.findOne(id);
    }


    public void getByName(String name) {

    }
}
