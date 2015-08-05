package com.ukrlegislation.controllers;

import com.ukrlegislation.entities.Deputy;
import com.ukrlegislation.entities.User;
import com.ukrlegislation.services.DeputyService;
import com.ukrlegislation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dima on 7/18/15.
 */
@RestController
@RequestMapping(value = "/deputy")
public class DeputyController {

    @Autowired
    DeputyService deputyService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Iterable<Deputy> getAllDeputy() {
        return deputyService.getAll();
    }

    @RequestMapping(value = "/{id}/",method = RequestMethod.GET)
    public Deputy getDeputyById(@PathVariable long id) {
        return deputyService.getById(id);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public void addDeputy(@RequestBody Deputy deputy) {
        deputyService.add(deputy);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public void updateDeputy(@PathVariable long id, @RequestBody Deputy deputy) {
        deputy.setId(id);
        deputyService.update(deputy);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteDeputy(@PathVariable long id) {
        deputyService.delete(id);
    }

}
