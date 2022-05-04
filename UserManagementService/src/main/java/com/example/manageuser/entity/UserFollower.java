package com.example.manageuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@ToString
public class UserFollower
{
	//~ Instance fields --------------------------
	/**  */

	@JoinColumn(
		name = "follower",
		referencedColumnName = "user",
		insertable = true,
		updatable = false
	)
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToOne(fetch = FetchType.LAZY)
	User follower;

	/**  */
	@JoinColumn(
		name = "following",
		referencedColumnName = "user",
		insertable = true,
		updatable = false
	)
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToOne(fetch = FetchType.LAZY)
	User following;

	/**  */
	@GeneratedValue
	@Id
	private int id;
}
