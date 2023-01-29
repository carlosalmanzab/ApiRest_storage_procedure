package com.company.ApiRest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.ApiRest.util.CarUtil;
import com.company.ApiRest.model.Car;
import com.company.ApiRest.service.CarServiceImpl;

@RestController
@RequestMapping("/api")
public class CarController {

	@Autowired
	CarServiceImpl carService;

	@GetMapping("/car")
	public ResponseEntity<List<Car>> list() {
		List<Car> cars = carService.list();
		return new ResponseEntity<>(cars, HttpStatus.OK);
	}

	@GetMapping("car/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Optional<Car> car = carService.finById(id);
		return new ResponseEntity<>(car, HttpStatus.OK);
	}

	@PostMapping("/car")
	public ResponseEntity<?> save(@RequestBody Car car) {
		carService.save(car);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/car/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		carService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/car/{id}")
	public ResponseEntity<?> update(@RequestBody Car carUpdate, @PathVariable("id") Long id) {
		Car carCurrent = carService.finById(id).get();
		Car carFinal = null;

		Map<String, Object> response = new HashMap<>();

		if (carCurrent == null) {
			response.put("mensaje", "El usuario con id ".concat(" ").concat("no existe"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			carFinal = CarUtil.carUpdateComparatorNotNull(carCurrent, carUpdate);
			carService.update(carFinal);
			
		} catch (Exception e) {
			response.put("mensaje", "error al comparar datos");
			response.put("error", e);
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El carro ha sido actualizado");
		response.put("Car", carFinal);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);

	}
}
