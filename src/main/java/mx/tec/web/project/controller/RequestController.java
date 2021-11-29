package mx.tec.web.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.web.project.manager.ContactsManager;
import mx.tec.web.project.vo.ContactVO;
import mx.tec.web.project.vo.UserVO;

@RestController
@CrossOrigin(origins = "${client.url}")
@RequestMapping("/api/")
@Validated
public class RequestController {
	private static final Logger log = LoggerFactory.getLogger(RequestController.class);
	
	/**
	 * Referencce to the Contacats Manager
	 */
	@Resource
	private ContactsManager contactsManager;

	/**
	 * Get the contasts of a given user by the user_id
	 * @param user_id
	 * @return A list of Contact Value Objects
	 */
	@GetMapping("/contacts/{user_id}")
	public ResponseEntity<List<Long>> getContacts(@PathVariable(value = "user_id") @Min(value = 0, message = "The user_id must be positive") Long user_id) {
		log.debug("Getting the contacts by user_id: {}", user_id);
		List<Long> contacts = contactsManager.getContacts(user_id);
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}
}

