package mx.tec.web.project.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mx.tec.web.project.entity.Contact;
import mx.tec.web.project.mapper.ContactMapper;
import mx.tec.web.project.repository.ContactRepository;
import mx.tec.web.project.vo.ContactVO;

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
        //List<ContactVO> contactDetails;
        return contactIds;
    }
    
}
