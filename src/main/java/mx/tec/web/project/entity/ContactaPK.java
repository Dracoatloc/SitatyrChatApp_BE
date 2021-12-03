package mx.tec.web.project.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

/**
 * Ojbect for the combined primary key of the Contacta Table
 * @author Victor-Guerra
 */
@Embeddable
public class ContactaPK implements Serializable{

	/** Contact userId */
    private Long userIdUsuario;

	/** Contact contactId */
    private Long userIdContacto;
    
    /**
     * No arguments constructor
     */
    private ContactaPK() {}

    /**
     * Constructor including all the properties
     * @param userIdUsuario User id of user
     * @param userIdContacto Contact id of contact
     */
    public ContactaPK(Long userIdUsuario, Long userIdContacto) {
        this.userIdUsuario = userIdUsuario;
        this.userIdContacto = userIdContacto;
    }
    
    /**
     * @return the userIdUsuario of the User
     */
    public Long getUserIdUsuario() {
        return this.userIdUsuario;
    }
    
    /**
     * @param userId the userIdUsuario to set to the User
     */
    public void setUserIdUsuario(Long userId) {
        this.userIdUsuario = userId;
    }

    /**
     * @return the userIdContacto of the User
     */
    public Long getUserIdContacto() {
        return this.userIdContacto;
    }
    
    /**
     * @param contactId the contactId to set to the User
     */
    public void setUserIdContacto(Long contactId) {
        this.userIdContacto = contactId;
    }
    
    /**
	 * Calculate the equiality using all the paremeters
	 * @param obj the other object with which is going to be compared
	 * @return true or false depending on the result of the comparison
	 */
    @Override
    public boolean equals(Object o) {
        if(this == o) {
           return true; 
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        
        ContactaPK that = (ContactaPK) o;
        return Objects.equals(userIdUsuario, that.userIdUsuario) && Objects.equals(userIdContacto, that.userIdContacto); 
    }
    
    /**
	 * Calculate the hashcode using all the paremeters
	 * @return hash generated with the paremeters
	 */
    @Override
    public int hashCode() {
        return Objects.hash(userIdUsuario, userIdContacto);
    }
}
