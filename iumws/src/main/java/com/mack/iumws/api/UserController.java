/**
 * 
 */
package com.mack.iumws.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mack.iumws.data.beans.User;
import com.mack.iumws.data.repo.UserRepository;

import jakarta.validation.Valid;

/**
 * @author Bhagwat Kolte
 *
 */
@RestController
public class UserController {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository repository;
	
	
	@GetMapping("/user/all")
	public List<User> getAllUsers(){
		LOGGER.info("Retrieve all users");
		return repository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getUser(@PathVariable Integer id){
		LOGGER.info("Retrieve user details for :" +id);
		Optional<User> userFound = repository.findById(id);
		
		if(userFound.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userFound.get());
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) throws URISyntaxException{
		User newUser = repository.save(user);

		return ResponseEntity.created(new URI(user.getUserID().toString())).build();

	}

}
