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
	public String hashPassword(String passWord) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(passWord);
	}
}
