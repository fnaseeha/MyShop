package lk.nasi.UserProfileService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.nasi.UserProfileService.model.Profile;

@Repository
public interface ProfileUserRepository extends JpaRepository<Profile, Integer>{

//	@Query(value="SELECT * FROM item  WHERE shoppingCart_id = :cartId and title = :title",nativeQuery=true)
//	Optional<Item> existItem(@Param("title") String title,@Param("cartId") int cartId);
//	
	@Query(value="SELECT * FROM profile  WHERE email = :username",nativeQuery=true)
	Optional<Profile> findByUsername(@Param("username") String username);
	
	@Query(value="SELECT * FROM profile  WHERE email = :username and password = :password",nativeQuery=true)
	Optional<Profile> findByCredential(@Param("username") String username,@Param("password") String password);
}
