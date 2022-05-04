package com.example.manageuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


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
public class User implements Serializable
{
	//~ Static fields/initializers ---------------
	/**  */
	private static final long serialVersionUID = -3352489885371635475L;
	//~ Instance fields --------------------------
	/**  */
	@GeneratedValue
	@Id
	private int id;

	/**  */
	private String user;
}
