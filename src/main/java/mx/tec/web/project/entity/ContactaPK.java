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

    private Long userIdUsuario;
    
    private Long userIdContacto;
    
    private ContactaPK() {}

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
    
    @Override
    public int hashCode() {
        return Objects.hash(userIdUsuario, userIdContacto);
    }
}
