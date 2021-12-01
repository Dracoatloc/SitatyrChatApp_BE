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

/**
 * Entity Object for the database implementation of Contacta; the relationship between User and Contact
 * @author Victor-Guerra
 */
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
    private Date dateAdded;

    private Contacta() {}

    public Contacta(User user, Contact contact) {
        this.user = user;
        this.contact = contact;
        this.dateAdded = new Date();
    }
    
    /**
     * Get the Primary key of Contacta
     * @return this.id
     */
    public ContactaPK getId() {
        return new ContactaPK(this.user.getId(), this.contact.getId());
    }
    
    /**
     * @param newId the new id to set
     */
    public void setId(ContactaPK newId) {
        this.id = newId;
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
    public void setUser(User user) {
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
    public void setContact(Contact contact ) {
        this.contact = contact;
    }

    /**
     * Get the dateAdded of the table
     * @return this.dateAdded
     */
    public Date getDateAdded() {
        return this.dateAdded;
    }
    
    /**
     * @param date the new dateAdded to set
     */
    public void setDateAdded(Date date ) {
        this.dateAdded = date;
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
