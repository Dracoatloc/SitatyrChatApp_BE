/**
 * 
 */
package mx.tec.web.project.manager;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import mx.tec.web.project.util.JsonWebTokenUtil;
import mx.tec.web.project.vo.CredentialsVO;
import mx.tec.web.project.vo.JsonWebTokenVO;

/**
 * @author Usuario
 *
 */
@Service
public class LoginManager {

	@Resource
	UserDetailsService userDAO;
	
	@Resource
	AuthenticationManager authenticationManager;
	
	@Resource
	JsonWebTokenUtil jwtTokenUtil;
	
	public JsonWebTokenVO authenticate(CredentialsVO credentials) throws AuthenticationException {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
		final UserDetails userDetails = userDAO.loadUserByUsername(credentials.getUsername());
		return new JsonWebTokenVO(jwtTokenUtil.generateToken(userDetails));
	}
	
	
	public Optional<UsernamePasswordAuthenticationToken> authenticate (final String username, final String token) {
		Optional<UsernamePasswordAuthenticationToken> authenticationToken = Optional.empty();
		UserDetails userDetails = userDAO.loadUserByUsername(username);
		
		if(jwtTokenUtil.validateToken(token, userDetails)) {
			UsernamePasswordAuthenticationToken userPassQuthToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());
			authenticationToken = Optional.of(userPassQuthToken);
		}
		
		return authenticationToken;
	}
}
