package lk.nasi.userService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.nasi.userService.model.User;


public interface UserRepository extends JpaRepository<User,Integer>{
	
	Optional<User> findByUsername(String name);
    
}

