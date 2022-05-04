package com.example.manageuser.service;

import com.example.manageuser.entity.User;
import com.example.manageuser.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@Service
public class UserService
{
	//~ Instance fields --------------------------
	/**  */
	@Autowired
	private UserRepository userRepository;
	//~ Methods ----------------------------------
	/**
	 * Create user
	 *
	 * @param   User
	 * @return
	 */
	public User createUser(String username)
	{
		User user = userRepository.findByUser(username);

		return userRepository.save(user);
	}
	
	/**
	 * Get user by ID
	 *
	 * @param   id
	 * @return
	 */
	public User getUserById(int id)
	{
		return userRepository.findById(id).orElse(null);
	}
	
	/**
	 * Get user by username
	 *
	 * @param   user
	 * @return
	 */
	public User getUser(String username)
	{
		User existingUser = userRepository.findByUser(username);
		if (existingUser == null)
		{
			existingUser = new User();
			existingUser.setUser(username);
			userRepository.save(existingUser);
		}

		return existingUser;
	}
}
