package com.example.manageuser.controller;

import com.example.manageuser.entity.User;
import com.example.manageuser.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@RestController
public class UserController
{
	//~ Instance fields --------------------------
	/**  */
	@Autowired
	UserService userService;
	//~ Methods ----------------------------------
	/**  */
	/**
	 * Add user
	 *
	 * @return
	 */
	@PostMapping("/addUser")
	public User addUser(@PathVariable
		String user)
	{
		return userService.createUser(user);
	}
}
