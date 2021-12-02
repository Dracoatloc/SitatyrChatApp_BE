/**
 * 
 */
package mx.tec.web.project.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import mx.tec.web.project.entity.User;
import mx.tec.web.project.vo.UserVO;

/**
 * @author Usuario
 *
 */
@Component
public class UserMapper {
	@Resource
	private ModelMapper modelMapper;
	
	/**
	 * Convert from User Entity to User VO
	 * @param user User Entity to convert 
	 * @return User VO converted
	 */
	public UserVO convertToVO(final User user) {
		return modelMapper.map(user, UserVO.class);
	}
	
	public List<UserVO> convertToVOList (final List<User> users){
		final List<UserVO> usersVO = new ArrayList<>();
		
		for (final User user : users) {
			usersVO.add(convertToVO(user));
		}
		
		return usersVO;
	}
	
	/**
	 * Convert from User VO to User Entity
	 * @param user User VO to convert 
	 * @return User Entity converted
	 */
	public User convertToEntity (final UserVO userVO) {
		return modelMapper.map(userVO, User.class);
	}
	
	
	public Optional<UserVO> convertToOptionalVO (final Optional<User> user){
		Optional<UserVO> userVO = Optional.empty();
		
		if (user.isPresent()) {
			userVO = Optional.of(convertToVO(user.get()));
		}
		
		return userVO;
		
	}
	
	
}
