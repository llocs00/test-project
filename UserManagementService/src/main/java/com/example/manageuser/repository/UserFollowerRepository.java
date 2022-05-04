package com.example.manageuser.repository;

import com.example.manageuser.entity.UserFollower;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@RepositoryRestResource
public interface UserFollowerRepository extends JpaRepository<UserFollower, Integer>
{
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param   user
	 * @param   followedBy
	 * @return
	 */
	@Query(
		nativeQuery = true,
		value = "select * from user_follower  where following = ?1 and follower = ?2"
	)
	UserFollower getByRecord(String following, String follower);
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   user
	 * @return
	 */
	@Query(
		nativeQuery = true,
		value = "select count(*) from user_follower  where following = ?1"
	)
	int countFollowers(String user);
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   user
	 * @return
	 */
	@Query(
		nativeQuery = true,
		value = "select count(*) from user_follower  where follower = ?1"
	)
	int countFollowing(String user);
}
