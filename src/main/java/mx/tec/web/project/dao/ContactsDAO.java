package mx.tec.web.project.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mx.tec.web.project.entity.Contact;
import mx.tec.web.project.mapper.ContactMapper;
import mx.tec.web.project.repository.ContactRepository;
import mx.tec.web.project.vo.ContactVO;
import mx.tec.web.project.vo.UserVO;

@Component("jpa")
public class ContactsDAO {
    /**
     * A reference to the Contacts Repository
     */
    @Resource
    private ContactRepository contactRepo;
    
    @Resource
    private ContactMapper contactMapper;

    public List<Long> findContactsByUserId(Long id) {
        List<Long> contactIds = contactRepo.findContactsByUserId(id);
        /*
        List<ContactVO> contactDetails = new ArrayList<>();
        for (final Long contactId: contactIds) {
            Optional<Contact> contacto = contactRepo.findById(contactId);
            if(contacto.isPresent()){
                contactDetails.add(contactMapper.convertToVO(contacto.get()));
            }
        }
        */
        return contactIds;
    }
    
    
    /**
	 * Method to find an specific contact by its username
	 * @param username Username of the contact to be found
	 * @return Optional Contact VO found by username
	 */
	public Optional<ContactVO> findByUsername(String username) {
		return contactMapper.convertToOptionalVO(contactRepo.findByUsername(username));
	}
	
	/**
	 * Method to insert contact into the database
	 * @param contact Contact to insert in the database
	 * @return Contact VO saved in the database
	 */
	public ContactVO insert(final ContactVO contact) {
		return contactMapper.convertToVO(contactRepo.save(contactMapper.convertToEntity(contact)));
	}
    
}
