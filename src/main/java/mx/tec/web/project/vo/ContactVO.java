package mx.tec.web.project.vo;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Value Object for internal manipulation of Contact
 * @author Victor-Guerra
 */
public class ContactVO {
	
	/** ContactVO id*/
	private Long id;

	/** ContactVO email*/
	@Email
	@NotBlank(message = "Email is mandatory.")
	private String email;
	
	/** ContactVO name*/
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	/** ContactVO username*/
	@NotBlank(message = "Username is mandatory.")
	private String username;

	/** ContactVO userImage*/
	private String userImage;
	
	/** ContactVO birthday*/
	@DateTimeFormat
	@NotBlank(message = "Date of Birth is mandatory.")
	private String birthday;
	
	/** ContactVO age*/
	@Digits(integer = 2, fraction = 0)
	private int age;
	
	/** ContactVO nationality*/
	@NotBlank(message = "Nationality is mandatory.")
	private String nationality;

	/** ContactVO preferredMusic*/
	private String preferredMusic;

	/** ContactVO status*/
	private String status;
	
	/**
	 * No arguments constructor
	 */
	public ContactVO () {}
	
	/**
	 * All arguments constructor
	 * @param id ContactVO id
	 * @param email ContactVO email
	 * @param name ContactVO name
	 * @param username ContactVO username
	 * @param userImage ContactVO userImage
	 * @param birthday ContactVO birthday
	 * @param nationality ContactVO nationality
	 * @param preferredMusic ContactVO preferred music
	 * @param status ContactVO status
	 */
	public ContactVO (Long id, 
				   String email, 
				   String name, 
				   String username, 
				   String userImage, 
				   String birthday, 
				   String nationality, 
				   String preferredMusic, 
				   String status) {
		this.id = id;
		this.email = email;
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
