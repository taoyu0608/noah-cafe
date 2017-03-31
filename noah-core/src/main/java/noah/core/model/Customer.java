package noah.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "CUSTOMER")
@EqualsAndHashCode(of = { "email" })
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * The username.
	 */
	@Column(name = "USERNAME", length = 50, unique = true, nullable = false)
	private String username;
	
	/**
	 * The e-mail.
	 */
	@Column(name = "EMAIL", length = 300, nullable = false)
	private String email;

	/**
	 * The name.
	 */
	@Column(name = "NAME", length = 50, nullable = false)
	private String name;

}
