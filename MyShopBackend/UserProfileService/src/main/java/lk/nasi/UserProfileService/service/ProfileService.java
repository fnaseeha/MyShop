package lk.nasi.UserProfileService.service;

import java.util.Optional;

import lk.nasi.UserProfileService.model.AppUser;
import lk.nasi.UserProfileService.model.Profile;

public interface ProfileService {
	
	Profile save(Profile profile);
	
	Optional<Profile> getProfile(String email,String password);
	
	Optional<Profile> getProfile(String email);
	
	AppUser getProfile(Integer id);
}
