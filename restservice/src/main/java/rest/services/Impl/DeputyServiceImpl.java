package rest.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entities.Deputy;
import rest.repos.DeputyRepository;
import rest.services.DeputyService;

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

    public void getById(Long id) {
        deputyRepository.findOne(id);
    }

    public void getByName(String name) {

    }
}
