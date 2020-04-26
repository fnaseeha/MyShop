package lk.nasi.UserProfileService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nasi.UserProfileService.model.AppUser;
import lk.nasi.UserProfileService.model.Profile;
import lk.nasi.UserProfileService.repository.ProfileUserRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileUserRepository repository;
	
	@Override
	public Profile save(Profile profile) {
		return repository.save(profile);
	}

	@Override
	public Optional<Profile> getProfile(String username, String password) {
		return repository.findByCredential(username, password);
	}

	@Override
	public Optional<Profile> getProfile(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public AppUser getProfile(Integer id) {

		Optional<Profile> prof = repository.findById(id);
		if(prof.isPresent()){
			Profile p = prof.get();
			return new AppUser(p.getName(), p.getEmail(), p.isAdmin());
		}
		return null;
	}

}
