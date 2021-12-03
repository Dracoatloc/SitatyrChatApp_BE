/**
 * ContactRepository
 * Version 1.0
 */
package mx.tec.web.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.tec.web.project.entity.Contact;

import mx.tec.web.project.entity.Contacta;


/**
 * Contacts JPA Repository
 * @author Victor-Guerra
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
    /**
     * Find a Contacts List based on a given User Id
     * @param id used to find User
     * @return List of Contacta found
     */
    @Query("FROM Contacta WHERE user_id = :id")
    List<Contacta> findContactsByUserId(@Param("id") Long id);
    
    /**
     * Find Username by its username
     * @param username User username used to find
     * @return Optional contact found
     */
    Optional<Contact> findByUsername(String username);

    
}
