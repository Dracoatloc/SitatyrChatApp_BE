/**
 * 
 */
package mx.tec.web.project.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Usuario
 *
 */
@Component
public class SecurityHelper {
	
	/**
	 * Hash a password with bcrypt
	 * @param passWord to generate the hash
	 * @return the hashed password generated
	 */
	public String hashPassword(String passWord) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(passWord);
	}
}
