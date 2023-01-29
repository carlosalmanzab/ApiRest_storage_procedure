package com.company.ApiRest.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.ApiRest.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

	@Query(value = "{call list_procedure() }", nativeQuery = true)
	List<Car> listProcedure();

	@Query(value = "{call find_by_id_procedure(:idIn) }",nativeQuery = true)
	Optional<Car> finByIdProcedure(@Param("idIn") Long idIn);
	
	@Transactional
	@Modifying
	@Query(value = "{call save_procedure(:brandIn,:modelIn,:yearIn,:kmIn) }", nativeQuery = true)
	void saveProcedure(
			@Param("brandIn") String brandIn,
			@Param("modelIn") String modelIn,
			@Param("yearIn") int yearIn,
			@Param("kmIn") int kmIn
	);
	
	@Transactional
	@Modifying
	@Query(value ="{call delete_procedure(:idIn) } ", nativeQuery = true)
	void deleteByIdProcedure(@Param("idIn") Long idIn);
	
	@Transactional
	@Modifying
	@Query(value = "{call update_procedure(:idIn,:brandIn,:modelIn,:yearIn,:kmIn) }", nativeQuery = true)
	void updateProcedure(
			@Param("idIn") Long idIn,
			@Param("brandIn") String brandIn,
			@Param("modelIn") String modelIn,
			@Param("yearIn") int yearIn,
			@Param("kmIn") int kmIn
	);
}
