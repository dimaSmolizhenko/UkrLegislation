package com.ukrlegislation.controller;

import com.ukrlegislation.model.User;
import com.ukrlegislation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ramax on 7/21/15.
 */
@RestController
public class HelloController {

	@Autowired
	UserService userService;

	@RequestMapping(name = "/hello",method = RequestMethod.GET)
	public List<User> printWelcome(ModelMap model) {
		return userService.getAllUsers();
	}
}
