package lk.nasi.orderService.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.nasi.orderService.model.Item;

@Repository
public interface itemRepository extends JpaRepository<Item, Integer> {

	@Modifying
	@Query(value="UPDATE item SET quantity = :quantity WHERE id = :item_id",nativeQuery=true)
	int updateQuantity(@Param("quantity") int quantity, @Param("item_id") int item_id);

//SELECT COUNT(c) > 0 FROM Contract c WHERE c.person.id = :pid
	@Query(value="SELECT * FROM item  WHERE myOrder_id = :cartId and title = :title",nativeQuery=true)
	Optional<Item> existItem(@Param("title") String title,@Param("cartId") int cartId);
	
	@Query(value="SELECT * FROM item  WHERE myOrder_id = :cartId",nativeQuery=true)
	List<Item> getAllReleventItems(@Param("cartId") int cartId);
	
	
	@Query(value="DELETE FROM item WHERE myOrder_id = :cartId",nativeQuery=true)
	void deleteAllReleventItems(@Param("cartId") int cartId);
}


