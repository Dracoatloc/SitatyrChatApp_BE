package mx.tec.web.project.manager;

import java.util.Optional;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.tec.web.project.dao.ContactsDAO;
import mx.tec.web.project.vo.ContactVO;
import mx.tec.web.project.vo.UserVO;

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
     * Retrieve the ids of all of the contacts of a given User
     * @param userId
     * @return List of Long
     */
    public List<Long> getContacts(Long userId) {
        return contactsDAO.findContactsByUserId(userId);
    }
    
    
}
