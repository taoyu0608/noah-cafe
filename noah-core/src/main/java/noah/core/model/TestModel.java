package noah.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TestModel")
@EqualsAndHashCode(of = { "username" })
public class TestModel implements Serializable {

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
	 * The password.
	 */
	@Column(name = "PASSWORD", length = 100, nullable = false)
	private String password;

}
