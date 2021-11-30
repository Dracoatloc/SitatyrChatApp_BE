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
	
	
	public Optional<UserVO> findById(final long id) {
		return userMapper.convertToOptionalVO(userRepo.findById(id));
	}

}
