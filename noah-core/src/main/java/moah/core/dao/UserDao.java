package moah.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import moah.core.model.User;

public interface UserDao extends JpaRepository<User, String> {
	
    /**
     * @param name
     *            - the name.
     *            
     * @return the user.
     */
	@Query("SELECT u FROM User u WHERE u.name=?1")
	public User findByName(String name);
	
    /**
     * @param username
     *            the username.
     * 
     * @return the users whose username, name or localName contains the query string.
     */
	@Query("SELECT u FROM User u WHERE "
			+ "UPPER(u.username) LIKE %?1% OR "
			+ "UPPER(u.name) LIKE %?1% OR "
			+ "UPPER(u.localName) LIKE %?1%")
	public List<User> findByLikeUsername(String username);
	
    @Query("SELECT u FROM User u WHERE "
            + "u.username = ?1 AND "
            + "u.email = ?2")
    public User findByUsernameAndEmail(String username, String email);
    
    @Query("UPDATE User u SET u.password = ?2 WHERE u.username = ?1")
    public void updataPassword(String username, String password);

}
