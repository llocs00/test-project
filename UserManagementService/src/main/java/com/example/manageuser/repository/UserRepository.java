package com.example.manageuser.repository;

import com.example.manageuser.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer>
{
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param   user
	 * @return
	 */
	@Query(
		nativeQuery = true,
		value = "select * from user  where user = ?"
	)
	User findByUser(String user);
}
