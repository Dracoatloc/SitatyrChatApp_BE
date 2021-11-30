package mx.tec.web.project.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import mx.tec.web.project.entity.Contact;
import mx.tec.web.project.vo.ContactVO;

/**
 * Mapper for the Contact Objects
 * 
 * @author Victor-Guerra
 */
@Component
public class ContactMapper {
    /**
     * Reference to Model Mapper
     */
    @Resource
    private ModelMapper modelMapper;
    
    /**
     * Convert from a Contact Entity to Contact Value Object
     * @param contact Contact Entity to convert
     * @return Contact Value Object conversion
     */
    public ContactVO convertToVO(final Contact contact) {
        return modelMapper.map(contact, ContactVO.class);
    }
    /**
     * Convert from a Contact Entity to Contact Value Object
     * @param contact Contact Entity to convert
     * @return Contact Value Object conversion
     */
    public List<ContactVO> convertToVOList(final List<Contact> contacts) {
        final List<ContactVO> contactVOs = new ArrayList<>();
        
        for (final Contact contact: contacts) {
            contactVOs.add(convertToVO(contact));
        }

        return contactVOs;
    }

    /**
     * Convert from a Contact Value Object to Contact Entity
     * @param contact Contact Value Object to convert
     * @return Contact Entity conversion
     */
    public Contact convertToEntity(final ContactVO contactvo) {
        return modelMapper.map(contactvo, Contact.class);
    }
}
