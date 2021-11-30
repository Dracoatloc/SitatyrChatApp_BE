package mx.tec.web.project.vo;

/**
 * Value Object for internal manipulation of Contact
 * @author Victor-Guerra
 */
public class ContactVO {
	private Long id;
	private String email;
	private String name;
	private String username;
	private String userImage;
	private String birthday;
	private int age;
	private String nationality;
	private String preferredMusic;
	private String status;
	
	public ContactVO () {}
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
