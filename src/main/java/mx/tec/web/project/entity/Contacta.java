package mx.tec.web.project.entity;


import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;

@Entity
public class Contacta {
    
    @EmbeddedId
    private ContactaPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userIdUsuario")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userIdContacto")
    private Contact contact;

    @Column(name = "date_added")
    @NotNull
    private Date date_added;

    private Contacta() {}

    public Contacta(User user, Contact contact) {
        this.user = user;
        this.contact = contact;
        this.date_added = new Date();
    }
    
    /**
     * Get the Primary key of Contacta
     * @return this.id
     */
    public ContactaPK getId() {
        return new ContactaPK(this.user.getId(), this.contact.getId());
    }
    
    /**
     * @param new_id the new id to set
     */
    public void setId(ContactaPK new_id) {
        this.id = new_id;
    }

    /**
     * Get the user
     * @return this.id
     */
    public User getUser() {
        return this.user;
    }
    
    /**
     * @param user the new user to set
     */
    public void setUserIdUsuario(User user) {
        this.user = user;
    }

    /**
     * Get the coontact of the table
     * @return this.id
     */
    public Contact getContact() {
        return this.contact;
    }
    
    /**
     * @param contact the new contact to set
     */
    public void setId(Contact contact ) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
           return true; 
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Contacta that = (Contacta) o;
        return Objects.equals(user, that.user) && Objects.equals(contact, that.contact);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(user, contact);
    }
}
