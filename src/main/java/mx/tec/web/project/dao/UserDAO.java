/**
 * 
 */
package mx.tec.web.project.dao;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;


import mx.tec.web.project.entity.User;
import mx.tec.web.project.mapper.UserMapper;
import mx.tec.web.project.repository.UserRepository;
import mx.tec.web.project.vo.UserVO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Usuario
 *
 */
@Component
public class UserDAO implements UserDetailsService{
	
	/** Reference to User Repository*/
	@Resource
	private UserRepository userRepo;
	
	/**Reference to User Mapper*/
	@Resource
	private UserMapper userMapper;
	
	/**
	 * Loads the user by its username using user
	 * @param username Username to be loaded
	 * @return new User using User Details
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername (final String username) {
		Optional<User> user = userRepo.findByUsername(username);
		if(!user.isPresent()) {
			throw new UsernameNotFoundException(username);	
		}
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		User foundUser = user.get();
		
		return new org.springframework.security.core.userdetails.User(
				foundUser.getUsername(),
				foundUser.getPassword(),
				grantedAuthorities);
	}
	
	/**
	 * Method to find an specific user by its id
	 * @param id Id of the user to be found
	 * @return Optional User VO found by id 
	 */
	public Optional<UserVO> findById(final long id) {
		return userMapper.convertToOptionalVO(userRepo.findById(id));
	}
	
	/**
	 * Method to find an specific user by its username
	 * @param username Username of the user to be found
	 * @return Optional User VO found by username
	 */
	public Optional<UserVO> findByUsername(String username) {
		return userMapper.convertToOptionalVO(userRepo.findByUsername(username));
	}
	
	/**
	 * Method to insert user into the database
	 * @param user User to insert in the database
	 * @return User VO saved in the database
	 */
	public UserVO insert(final UserVO user) {
		return userMapper.convertToVO(userRepo.save(userMapper.convertToEntity(user)));
	}

}
