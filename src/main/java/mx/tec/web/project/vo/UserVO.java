package mx.tec.web.project.vo;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Value Object implementation for internal manipulation of User
 * @author Victor-Guerra
 */
public class UserVO {
	
	/** UserVO id*/
	private Long id;
	
	/** UserVO email*/
	@Email
	@NotBlank(message = "Email is mandatory.")
	private String email;
	
	/** UserVO password*/
	@NotBlank(message = "Password is mandatory.")
	private String password;
	
	/** UserVO name*/
	@NotBlank(message = "Name is mandatory.")
	private String name;
	
	/** UserVO username*/
	@NotBlank(message = "Username is mandatory.")
	private String username;
	
	/** UserVO userImage*/
	private String userImage;
	
	/** UserVO birthday*/
	@NotBlank(message = "Date of Birth is mandatory.")
	private String birthday;
	
	/** UserVO age*/
	@Digits(integer = 2, fraction = 0)
	private int age;
	
	/** UserVO nationality*/
	@NotBlank(message = "Nationality is mandatory.")
	private String nationality;
	
	/** UserVO preferred music*/
	private String preferredMusic;
	
	/** UserVO status*/
	private String status;
	
	/**
	 * No arguments constructor
	 */
	public UserVO () {}
	
	/**
	 * All arguments constructor
	 * @param id User id
	 * @param email User email
	 * @param password User password
	 * @param name User name
	 * @param username User username
	 * @param userImage User user image
	 * @param birthday User Birthday
	 * @param nationality User nationality
	 * @param preferredMusic User preferred music
	 * @param status User status
	 */
	public UserVO (Long id, 
				   String email, 
				   String password, 
				   String name, 
				   String username, 
				   String userImage, 
				   String birthday, 
				   String nationality, 
				   String preferredMusic, 
				   String status) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.username = username;
		this.userImage = userImage;
		this.birthday = birthday;
		this.nationality = nationality;
		this.preferredMusic = preferredMusic;
		this.status = status;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the userImage
	 */
	public String getUserImage() {
		return userImage;
	}
	/**
	 * @param userImage the userImage to set
	 */
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * @return the preferredMusic
	 */
	public String getPreferredMusic() {
		return preferredMusic;
	}
	/**
	 * @param preferredMusic the preferredMusic to set
	 */
	public void setPreferredMusic(String preferredMusic) {
		this.preferredMusic = preferredMusic;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
