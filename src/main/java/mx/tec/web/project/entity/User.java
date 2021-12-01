package mx.tec.web.project.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable{
	
	/**User id*/
	@Id
	@GeneratedValue
	private Long id;

	/**User email*/
	@NotNull
	private String email;
	
	/**User password*/
	@NotNull
	private String password;

	/**User name*/
	@NotNull
	private String name;

	/**User username*/
	@NotNull
	private String username;
	
	/**User userImage*/
	@NotNull
	private String userImage;

	/**User birthDay*/
	@NotNull
	private String birthDay;

	/**User age*/
	@NotNull
	private int age;

	/**User nationality*/
	@NotNull
	private String nationality;

	/**User preferredMusic*/
	@NotNull
	private String preferredMusic;

	/**User status*/
	@NotNull
	private String status;

	//@JoinTable(name = "Contacta", joinColumns = @JoinColumn(name = "user_id_Usuario"), inverseJoinColumns = @JoinColumn(name = "user_id_Contacto"))
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contacta> contacts = new ArrayList<>();
	
	/**
	 * No arguments constructor
	 */
	public User() {
		
	}
	
	/**
	 * Constructor including all the properties
	 * @param id User id
	 * @param email User email
	 * @param password User password
	 * @param name User name
	 * @param username User username
	 * @param userImage User user image
	 * @param birthDay User  Birthday
	 * @param age User age
	 * @param nationality User nationality
	 * @param preferredMusic User preferred Music
	 * @param status User status
	 * @param contacts user List of contacts
	 */
	public User(Long id, @NotNull String email, @NotNull String password, @NotNull String name,
			@NotNull String username, @NotNull String userImage, @NotNull String birthDay, @NotNull int age,
			@NotNull String nationality, @NotNull String preferredMusic, @NotNull String status,
			List<Contacta> contacts) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.username = username;
		this.userImage = userImage;
		this.birthDay = birthDay;
		this.age = age;
		this.nationality = nationality;
		this.preferredMusic = preferredMusic;
		this.status = status;
		this.contacts = contacts;
	}
	
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
	 * Calculate the hashcode using all the paremeters
	 * @return hash generated with the paremeters
	 */
	@Override
	public int hashCode() {
		return Objects.hash(age, birthDay, contacts, email, id, name, nationality, password, preferredMusic, status,
				userImage, username);
	}

	/**
	 * Calculate the equiality using all the paremeters
	 * @param obj the other object with which is going to be compared
	 * @return true or false depending on the result of the comparison
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
