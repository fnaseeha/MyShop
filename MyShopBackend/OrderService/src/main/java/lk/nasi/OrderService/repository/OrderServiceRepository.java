package lk.nasi.orderService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.nasi.orderService.model.myOrder;

@Repository
public interface OrderServiceRepository extends JpaRepository<myOrder, Integer> {

	@Query(value="SELECT * FROM myorder  WHERE user_id = :id",nativeQuery=true)
	List<myOrder> findByUserId(int id);

}
