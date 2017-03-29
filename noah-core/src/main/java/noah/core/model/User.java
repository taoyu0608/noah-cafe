package noah.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USERS")
@EqualsAndHashCode(of = { "username" })
//@ToString(of = { "username", "name", "localName" })
//public class User implements UserDetails, Serializable {
public class User implements Serializable {

	private static final long serialVersionUID = 1001L;

	/**
	 * The username.
	 */
	@Id
	@Column(name = "USERNAME", length = 50, unique = true, nullable = false)
	private String username;
	
	/**
	 * The password.
	 */
	@Column(name = "PASSWORD", length = 100, nullable = false)
	private String password;

//	/**
//	 * The e-mail.
//	 */
//	@Column(name = "EMAIL", length = 200, nullable = false)
//	private String email;
//
//	/**
//	 * The name.
//	 */
//	@Column(name = "NAME", length = 50, nullable = false)
//	private String name;
//
//	/**
//	 * The locale name.
//	 */
//	@Column(name = "LOCAL_NAME", length = 200, nullable = false)
//	private String localName;
//
//	/**
//	 * previous passwords
//	 */
//	@Column(name = "old_passwords", length = 2000)
//	private String oldPasswords;
//
//	@CreatedDate
//	@Column(name = "CREATED_DATE")
//	private Date createdDate;
//
//	@LastModifiedDate
//	@Column(name = "UPDATED_DATE")
//	private Date updatedDate;
//
//	/**
//	 * Check user is enable or not.
//	 */
//	@Column(name = "IS_ENABLED")
//	private boolean isEnabled = true;
//
//	@Column(name = "IS_LOCKED")
//	private boolean isLocked = false;
//
//	@Column(name = "IS_EXPIRED")
//	private boolean isExpired = false;
//	
//	@Column(name = "IS_RESET")
//    private Boolean isResetPwd = false;
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return !isLocked;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return !isExpired;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return !isExpired;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return null;
//	}

}
