package mx.tec.web.project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import mx.tec.web.project.entity.Contact;
import mx.tec.web.project.entity.Contacta;
import mx.tec.web.project.mapper.ContactMapper;
import mx.tec.web.project.repository.ContactRepository;
import mx.tec.web.project.vo.ContactVO;

/**
 * Implementation for the Contacts Data Access Object
 * @author Victor-Guerra
 */
@Component("jpa")
public class ContactsDAO {
    /**
     * A reference to the Contacts Repository
     */
    @Resource
    private ContactRepository contactRepo;
    
    /**
     * A referencec to the Contact Mapper for Entity and Value Objects
     */
    @Resource
    private ContactMapper contactMapper;

    /**
     * Finds Contact Details based on the User id provided
     * @param id
     * @return List<ContactVO> contactDetails ; the list of the users' contacts
     */
    public List<ContactVO> findContactsByUserId(Long id) {
        List<Contacta> contactaObjects = contactRepo.findContactsByUserId(id);
        List<Long> contactIds = new ArrayList<>();

        for (Contacta object: contactaObjects) {
            contactIds.add(object.getId().getUserIdContacto());
        }

        List<ContactVO> contactDetails = new ArrayList<>();
        for (final Long contactId: contactIds) {
            Optional<Contact> contacto = contactRepo.findById(contactId);
            if(contacto.isPresent()){
                contactDetails.add(contactMapper.convertToVO(contacto.get()));
            }
        }
        return contactDetails;
    }
    
}
