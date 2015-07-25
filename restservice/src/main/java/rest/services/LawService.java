package rest.services;


import rest.entities.Law;

import java.util.List;

/**
 * Created by dima on 7/18/15.
 */
public interface LawService {

    public List<Law> getAll();

    public void add(Law law);

    public void delete(Long id);

    public void getById(Long id);

    public void getByName(String name);
}
