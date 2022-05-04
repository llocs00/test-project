package com.example.manageuser.service;

import com.example.manageuser.entity.UserFollower;
import com.example.manageuser.repository.UserFollowerRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@Service
public class UserFollowerService
{
	//~ Instance fields --------------------------
	/**  */
	@Autowired
	private UserFollowerRepository userFollowerRepository;

	/**  */
	@Autowired
	private UserService userService;
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param   id
	 * @return
	 */
	public UserFollower addFollower(String following, String follower)
	{
		UserFollower userFollower = userFollowerRepository.getByRecord(following,
				follower);
		if (userFollower != null)
		{
			return null;
		}
		else
		{
			userFollower = new UserFollower();
			userFollower.setFollowing(userService.getUser(following));
			userFollower.setFollower(userService.getUser(follower));
		}

		return userFollowerRepository.save(userFollower);
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   user
	 * @return
	 */
	public int countFollowers(String following)
	{
		return userFollowerRepository.countFollowers(following);
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   user
	 * @return
	 */
	public int countFollowing(String following)
	{
		return userFollowerRepository.countFollowing(following);
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   user
	 * @return
	 */
	public String unfollow(String follower, String following)
	{
		String result = null;
		UserFollower userFollower = userFollowerRepository.getByRecord(following, follower);

		if (userFollower == null)
		{
			result = "You are not following " + following;
		}
		else
		{
			userFollowerRepository.delete(userFollower);
			result = "Request to unfollow " + following + " successful.";
		}

		return result;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   user
	 * @return
	 */
	public String removeFollower(String user, String follower)
	{
		String result = null;
		UserFollower userFollower = userFollowerRepository.getByRecord(follower, user);

		if (userFollower == null)
		{
			result = "You are not being followed by " + user;
		}
		else
		{
			userFollowerRepository.delete(userFollower);
			result = "Request to remove " + follower + " successful.";
		}

		return result;
	}
}
