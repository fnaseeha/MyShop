package lk.nasi.UserProfileService.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lk.nasi.UserProfileService.model.Profile;
import lk.nasi.UserProfileService.service.ProfileService;
import lk.nasi.UserProfileService.util.CustomErrorType;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProfileController {
	
	public static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	private ProfileService profileService;

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Object createUser(@RequestBody Profile newUser) {
		if (profileService.getProfile(newUser.getEmail()).isPresent()) {
			
			logger.error("username Already exist " + newUser.getEmail());
			
			return new ResponseEntity<Object>(
					new CustomErrorType("user with username " + newUser.getEmail() + "already exist "),
					HttpStatus.CONFLICT);
		}
		newUser.setAdmin(false);
		
		return profileService.save(newUser);
	}


	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
	public Object login(@PathVariable String username,@PathVariable String password) {
		if (!profileService.getProfile(username,password).isPresent()) {
			
			return new ResponseEntity<Object>(
					new CustomErrorType("username or password is wrong"),
					HttpStatus.NOT_FOUND);
		}
		return profileService.getProfile(username,password).get();
		//return new ResponseEntity<Profile>(profileService.getProfile(username,password).get(),HttpStatus.FOUND);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Object getProfile(@PathVariable Integer id) {
		if (profileService.getProfile(id)==null) {
			
			return new ResponseEntity<Object>(
					new CustomErrorType("user not exist"),
					HttpStatus.NOT_FOUND);
		}
		return profileService.getProfile(id);
	}


	
	
	
	
	
	
	
	
}
