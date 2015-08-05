package com.ukrlegislation.controllers;

import com.ukrlegislation.entities.Bill;
import com.ukrlegislation.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dima on 7/18/15.
 */
@RestController
@RequestMapping(value = "/bill")
public class BillController {

    @Autowired
    BillService billService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Iterable<Bill> getAllBill() {
        return billService.getAll();
    }

    @RequestMapping(value = "/{id}/",method = RequestMethod.GET)
    public Bill getBillById(@PathVariable long id) {
        return billService.getById(id);
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public void addBill(@RequestBody Bill Bill) {
        billService.add(Bill);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public void updateBill(@PathVariable long id, @RequestBody Bill bill) {
        bill.setId(id);
        billService.update(bill);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteBill(@PathVariable long id) {
        billService.delete(id);
    }

}
