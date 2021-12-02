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
	
	@Resource
	public UserDAO userDAO;
	
	@Resource
	SecurityHelper encoder;
	
	public Optional<UserVO> getUser(final long id){
		return userDAO.findById(id);
	}
	
	public UserVO addUser(final UserVO user) {
		Optional<UserVO> foundUser =  userDAO.findByUsername(user.getUsername());
		if(foundUser.isPresent()) {
			throw new EntityExistsException("This user already exists " + user.getUsername());	
		} else {
			user.setPassword(encoder.hashPassword(user.getPassword()));
			return  userDAO.insert(user);
		}
	}
}
