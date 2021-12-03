/**
 * 
 */
package mx.tec.web.project.manager;

import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.EntityExistsException;

import org.springframework.stereotype.Service;

import mx.tec.web.project.dao.UserDAO;
import mx.tec.web.project.util.SecurityHelper;
import mx.tec.web.project.vo.UserVO;

/**
 * @author Usuario
 *
 */
@Service
public class UserManager {
	
	/**
	 * A reference to UserDAO
	 */
	@Resource
	public UserDAO userDAO;
	
	/**
	 * A reference to SecurityHelper to encode
	 */
	@Resource
	SecurityHelper encoder;
	
	/**
	 * Get a User from the database given a user id
	 * @param id to find the User
	 * @return User found from the database
	 */
	public Optional<UserVO> getUser(final long id){
		return userDAO.findById(id);
	}
	
	/**
	 * Add a new User to the database
	 * @param user User to be added
	 * @return User added to the database
	 */
	public UserVO addUser(final UserVO user) {
		Optional<UserVO> foundUser =  userDAO.findByUsername(user.getUsername());
		if(foundUser.isPresent()) {
			throw new EntityExistsException("This user already exists " + user.getUsername());	
		} else {
			user.setPassword(encoder.hashPassword(user.getPassword()));
			return  userDAO.insert(user);
		}
	}
	
	/**
	 * Method to find a User id by its username
	 * @param username to use in order to find the User
	 * @return id from the found User
	 */
	public long findUserIdByUsername(String username) {
		Optional<UserVO> foundUser =  userDAO.findByUsername(username);
		
		UserVO userFound = new UserVO();
		if(foundUser.isPresent()) {
			userFound = foundUser.get();
		}
		return userFound.getId();
	}
	
}
