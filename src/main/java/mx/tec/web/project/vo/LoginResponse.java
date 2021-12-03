/**
 * 
 */
package mx.tec.web.project.vo;

/**
 * @author Usuario
 *
 */
public class LoginResponse {
	
	/** UID */
	private static final long serialVersionUID = 4679985845204576425L;
	
	/** LoginResponse token*/
	private JsonWebTokenVO token;

	/** LoginResponse userId*/
	private long id;
	
	/**
	 * No arguments constructor
	 */
	public LoginResponse() {
	}
	
	/**
	 * All arguments constructor
	 * @param token Login response user token
	 * @param id Login response user id
	 */
	public LoginResponse(JsonWebTokenVO token, long id) {
		super();
		this.token = token;
		this.id = id;
	}
	
	
	/**
	 * @return the token
	 */
	public JsonWebTokenVO getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(JsonWebTokenVO token) {
		this.token = token;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
}
