/**
 * 
 */
package mx.tec.web.project.manager;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.tec.web.project.dao.UserDAO;
import mx.tec.web.project.vo.UserVO;

/**
 * @author Usuario
 *
 */
@Service
public class UserManager {
	
	@Resource
	public UserDAO userDAO;
	
	public Optional<UserVO> getUser(final long id){
		return userDAO.findById(id);
	}
}
