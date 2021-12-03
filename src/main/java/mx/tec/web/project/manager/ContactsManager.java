package mx.tec.web.project.manager;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.EntityExistsException;

import org.springframework.stereotype.Service;

import mx.tec.web.project.dao.ContactsDAO;
import mx.tec.web.project.vo.ContactVO;

/**
 * The Contacts Manager
 * @author Victor Guerra
 * @version 1.0
 */
@Service
public class ContactsManager {
    
	/**
     * Reference to the Contacts DAO
     */
    @Resource
    private ContactsDAO contactsDAO;

    /**
     * Retrieve the id's of all of the contacts of a given User
     * @param userId to get its contacts
     * @return List of contacts
     */
    public List<ContactVO> getContacts(Long userId) {
        return contactsDAO.findContactsByUserId(userId);
    }
    
    /**
     * Method to add a contact to the database
     * @param contact to be added to the data base
     * @return Contact which is inserted to the data base
     */
    public ContactVO addContact(final ContactVO contact) {
		Optional<ContactVO> foundContact =  contactsDAO.findByUsername(contact.getUsername());
		if(foundContact.isPresent()) {
			throw new EntityExistsException("This contact already exists " + contact.getUsername());	
		} else {
			return  contactsDAO.insert(contact);
		}
	}
    
    
}
