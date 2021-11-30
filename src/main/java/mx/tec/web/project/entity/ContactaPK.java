package mx.tec.web.project.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

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
     * @return the UserId of the User
     */
    public Long getUserIdUsuario() {
        return this.userIdUsuario;
    }
    
    /**
     * @param user_id the UserId to set to the User
     */
    public void setUserIdUsuario(Long user_id) {
        this.userIdUsuario = user_id;
    }

    /**
     * @return the UserId of the User
     */
    public Long getUserIdContacto() {
        return this.userIdContacto;
    }
    
    /**
     * @param user_id the UserId to set to the User
     */
    public void setUserIdContacto(Long contact_id) {
        this.userIdContacto = contact_id;
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
