package com.terra.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.terra.model.Store;


@Repository
public interface StoreRepository extends JpaRepository<Store,String> {
	
	@Query(value="SELECT s.* FROM stores s WHERE pin_code=:pincode", nativeQuery = true)
	List<Store> findByPincode(@Param("pincode") String pincode);
}
