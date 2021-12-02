/**
 * 
 */
package mx.tec.web.project.vo;

import java.io.Serializable;

/**
 * @author Usuario
 *
 */
public class JsonWebTokenVO implements Serializable {
	
	private static final long serialVersionUID = -4683200481070740123L;
	
	private final String token;

	public JsonWebTokenVO(String token) {
		this.token = token;
	}
	
	/**
	 * @return the token
	 */
	public String getToken() {
		return this.token;
	}
	
}
