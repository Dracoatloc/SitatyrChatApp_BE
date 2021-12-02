package mx.tec.web.project.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.security.sasl.AuthenticationException;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.web.project.manager.ContactsManager;
import mx.tec.web.project.manager.LoginManager;
import mx.tec.web.project.manager.UserManager;
import mx.tec.web.project.util.SecurityHelper;
import mx.tec.web.project.vo.ContactVO;

import mx.tec.web.project.vo.CredentialsVO;
import mx.tec.web.project.vo.JsonWebTokenVO;
import mx.tec.web.project.vo.UserVO;


/**
 * Controller Object for handling requests from the Front End
 */
@RestController
@CrossOrigin(origins = "*")
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
	 * Referencce to the Login Manager
	 */
	@Resource
	private LoginManager loginManager;
	
	/**
	 * Referencce to the User Manager
	 */
	@Resource
	private UserManager userManager;

	/**
	 * Get the contacts of a given user by the user_id
	 * @param user_id
	 * @return A list of Contact Value Objects
	 */
	@GetMapping("/contacts/{userId}")
	public ResponseEntity<List<ContactVO>> getContacts(@PathVariable(value = "userId") @Min(value = 0, message = "The userId must be positive") Long userId) {
		log.debug("Getting the contacts by userId: {}", userId);
		List<ContactVO> contacts = contactsManager.getContacts(userId);
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}



	@GetMapping("/contacts")
	public ResponseEntity<String> getTest() {
		log.debug("GET a /api/contacts");	
		return new ResponseEntity<>("Test GET to /api/contacts", HttpStatus.OK);
	}
	
	/**
	 * Authenticate to a session given user credentials
	 * @param credentials Credentials of the user to be checked
	 * @return Authentication of not
	 */
	@PostMapping("/user/login")
	public ResponseEntity<JsonWebTokenVO> createAuthenticationToken(@RequestBody CredentialsVO credentials){
		log.info("Authenticating user {}", credentials.getUsername());
		return ResponseEntity.ok(loginManager.authenticate(credentials));
	}
	
	/**
	 * Add a new user to the database
	 * @param user User to be added to database
	 * @return Response Entity with the created user and status code CREATED
	 */
	@PostMapping("/user/add")
	public ResponseEntity<UserVO> addUser(@RequestBody UserVO user) {
		log.info("User being created ", user.getUsername());
		return new ResponseEntity<>(userManager.addUser(user), HttpStatus.CREATED);
	}
	
	/**
	 * Add a new contact to the database
	 * @param contact Contact to be added to database
	 * @return Response Entity with the created contact and status code CREATED
	 */
	@PostMapping("/contact/add")
	public ResponseEntity<ContactVO> addContact(@RequestBody ContactVO contact) {
		log.info("Contact being created ", contact.getUsername());
		return new ResponseEntity<>(contactsManager.addContact(contact), HttpStatus.CREATED);
	}
	
	/**
	 * Handler to check if the credentials are valid
	 * @param ae Authentication Exception which is handled
	 * @return Response Entity with Exception message and status code UNAUTHORIZED
	 */
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> onSecurityException (final AuthenticationException ae) {
		log.error("Invalid Credentials ", ae);
		return new ResponseEntity<>(ae.getMessage(), HttpStatus.UNAUTHORIZED);

	}

}

