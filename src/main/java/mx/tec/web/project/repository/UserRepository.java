/**
 * 
 */
package mx.tec.web.project.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.tec.web.project.entity.User;
/**
 * @author Usuario
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	/**
	 * Find User by its username
	 * @param username User username used to find
	 * @return Optional User found
	 */
	Optional<User> findByUsername(String username);

}
