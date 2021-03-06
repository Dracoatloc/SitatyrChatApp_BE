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

	/** A Reference to the User Details Service*/
	@Resource
	UserDetailsService userDAO;
	
	/** A Reference to the Authentication Manager*/
	@Resource
	AuthenticationManager authenticationManager;
	
	/**A Reference to the Json Web Token Util*/
	@Resource
	JsonWebTokenUtil jwtTokenUtil;
	
	/**
	 * Method to authenticate and generate token with the credentials
	 * @param credentials Credentials of the user
	 * @return New token generated with the credentials
	 * @throws AuthenticationException
	 */
	public JsonWebTokenVO authenticate(CredentialsVO credentials) throws AuthenticationException {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
		final UserDetails userDetails = userDAO.loadUserByUsername(credentials.getUsername());
		return new JsonWebTokenVO(jwtTokenUtil.generateToken(userDetails));
	}
	
	/**
	 * Method to authenticate with username and token
	 * @param username Username form the User
	 * @param token Token of the user to validate
	 * @return Valid token
	 */
	public Optional<UsernamePasswordAuthenticationToken> authenticate(final String username, final String token) {
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
