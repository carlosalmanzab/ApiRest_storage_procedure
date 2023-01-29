package com.company.ApiRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.ApiRest.model.Car;
import com.company.ApiRest.repository.CarRepository;

@Service
public class CarServiceImpl {

	@Autowired
	CarRepository carRepository;
	
	public List<Car> list(){
		return carRepository.listProcedure();
	}
	
	public Optional<Car> finById(Long id){
		return carRepository.finByIdProcedure(id);
	}
	
	public void save(Car car) {
		carRepository.saveProcedure(
				car.getBrand(),
				car.getModel(),
				car.getYear(),
				car.getKm()
				);
	}
	
	public void delete(Long id) {
		carRepository.deleteByIdProcedure(id);
	}
	
	public void update(Car car) {
		carRepository.updateProcedure(
				car.getId(), 
				car.getBrand(), 
				car.getModel(), 
				car.getYear(), 
				car.getKm());
	}
}
