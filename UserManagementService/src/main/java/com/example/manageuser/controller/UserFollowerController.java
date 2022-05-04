package com.example.manageuser.controller;

import com.example.manageuser.service.UserFollowerService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@RestController
public class UserFollowerController
{
	//~ Instance fields --------------------------
	/**  */
	@Autowired
	UserFollowerService userFollowerService;
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param   Users
	 * @return
	 */
	@PostMapping("/addFollower")
	public ResponseEntity<String> addFollower(@RequestParam
		String follower, @RequestParam
		String following)
	{
		String result = null;
		if (userFollowerService.addFollower(following, follower) == null)
		{
			result = follower + " is already following " + following;
		}
		else
		{
			result = "Follow request succesful for " + following;
		}

		return ResponseEntity.ok(result);
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   user
	 * @return
	 */
	@GetMapping("/countFollowing/{user}")
	public ResponseEntity<String> countFollowing(@PathVariable
		String user)
	{
		return ResponseEntity.ok(user + " is following " + userFollowerService.countFollowing(user) + " user/s.");
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   user
	 * @return
	 */
	@GetMapping("/countFollowers/{user}")
	public ResponseEntity<String> countFollowers(@PathVariable
		String user)
	{
		return ResponseEntity.ok(user + " has " + userFollowerService.countFollowers(user) + " follower/s.");
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   follower
	 * @param   user
	 * @return
	 */
	@PutMapping("/unfollow")
	public ResponseEntity<String> unfollow(@RequestParam
		String follower, @RequestParam
		String user)
	{
		return ResponseEntity.ok(userFollowerService.unfollow(follower, user));
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   user
	 * @return
	 */
	@PutMapping("/removeFollower")
	public ResponseEntity<String> removeFollower(@RequestParam
		String user, @RequestParam
		String following)
	{
		return ResponseEntity.ok(userFollowerService.removeFollower(user, following));
	}
}
