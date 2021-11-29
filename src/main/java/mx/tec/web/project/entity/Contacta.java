package mx.tec.web.project.entity;


import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Contacta {
    @EmbeddedId
    private ContactaPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userIdUsuario")
    private User usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userIdContacto")
    private Contact contacto;

    @Column(name = "date_added")
    private Date date_added = new Date();

    private Contacta() {}

    public Contacta(User user, Contact contact) {
        this.usuario = user;
        this.contacto = contact;
        this.id = new ContactaPK(user.getId(), contact.getId());
    }
    
    /**
     * Get the Primary key of Contacta
     * @return this.id
     */
    public ContactaPK getId() {
        return this.id;
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
    public User getUsuario() {
        return this.usuario;
    }
    
    /**
     * @param user the new user to set
     */
    public void setUsuario(User user) {
        this.usuario = user;
    }

    /**
     * Get the coontact of the table
     * @return this.id
     */
    public Contact getContacto() {
        return this.contacto;
    }
    
    /**
     * @param contact the new contact to set
     */
    public void setId(Contact contact ) {
        this.contacto = contact;
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
        return Objects.equals(usuario, that.usuario) && Objects.equals(contacto, that.contacto);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(usuario, contacto);
    }
}
