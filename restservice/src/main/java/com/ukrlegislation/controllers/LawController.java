package com.ukrlegislation.controllers;

import com.ukrlegislation.entities.Law;
import com.ukrlegislation.entities.User;
import com.ukrlegislation.services.LawService;
import com.ukrlegislation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dima on 7/18/15.
 */
@Controller
public class LawController {

    @Autowired
    LawService lawService;

    @RequestMapping(value = "/law/",method = RequestMethod.GET)
    public Iterable<Law> getAllLaw() {
        return lawService.getAll();
    }

    @RequestMapping(value = "/law/{id}/",method = RequestMethod.GET)
    public Law getLawById(@PathVariable long id) {
        return lawService.getById(id);
    }

    @RequestMapping(value = "/law/",method = RequestMethod.PUT)
    public void addLaw(@RequestBody Law law) {
        lawService.add(law);
    }

    @RequestMapping(value = "/law/{id}",method = RequestMethod.POST)
    public void updateLaw(@PathVariable long id, @RequestBody Law law) {
        law.setId(id);
        lawService.update(law);
    }

    @RequestMapping(value = "/law/{id}",method = RequestMethod.DELETE)
    public void deleteLaw(@PathVariable long id) {
        lawService.delete(id);
    }

}
