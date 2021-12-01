package mx.tec.web.project.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Entity Object for the database implementation of User
 * @author Victor-Guerra
 */
@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;

	@NotNull
	private String name;

	@NotNull
	private String username;
	
	@NotNull
	private String userImage;

	@NotNull
	private String birthDay;

	@NotNull
	private int age;

	@NotNull
	private String nationality;

	@NotNull
	private String preferredMusic;

	@NotNull
	private String status;

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contacta> contacts = new ArrayList<>();
	
	/**
	 * @return the User id
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
	 * @return the User email
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
	 * @return the User password
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
	 * @return the User name
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
	 * @return the User username
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
	 * @return the User Image
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
	 * @return the User birthday
	 */
	public String getBirthDay() {
		return birthDay;
	}

	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	/**
	 * @return the User age
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
	 * @return the User nationality
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
	 * @return the User preferredMusic
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
	 * @return the User status
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

	/**
	 * Obtain the Hash code for the Object
	 * @return int hash
	 */
	@Override
	public int hashCode() {
		return Objects.hash(age, birthDay, contacts, email, id, name, nationality, password, preferredMusic, status,
				userImage, username);
	}

	/**
	 * Compare two User Objects
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return age == other.age && Objects.equals(birthDay, other.birthDay) && Objects.equals(contacts, other.contacts)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(nationality, other.nationality)
				&& Objects.equals(password, other.password) && Objects.equals(preferredMusic, other.preferredMusic)
				&& Objects.equals(status, other.status) && Objects.equals(userImage, other.userImage)
				&& Objects.equals(username, other.username);
	}
}
