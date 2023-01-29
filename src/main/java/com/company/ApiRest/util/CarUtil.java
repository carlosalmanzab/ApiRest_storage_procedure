package com.company.ApiRest.util;

import com.company.ApiRest.model.Car;

public class CarUtil {

	/**
	 * This method is in charge of comparing 
	 * the data of the update car parameter 
	 * and the current car, it returns a car 
	 * with the updated data
	 * @param carCurrent
	 * @param carUpdate
	 * @return car
	 */
	public static Car carUpdateComparatorNotNull(Car carCurrent, Car carUpdate) {
		String brand = null;
		String model = null;
		Integer year = 0;
		Integer km = 0;

		brand= carUpdate.getBrand() != null ? carUpdate.getBrand() : carCurrent.getBrand();
		model = carUpdate.getModel() != null ? carUpdate.getModel() : carCurrent.getModel();
		year = carUpdate.getYear() != 0 ? carUpdate.getYear() : carCurrent.getYear();
		km = carUpdate.getKm() != 0 ? carUpdate.getKm() : carCurrent.getKm();

		return new Car(carCurrent.getId(), brand, model, year, km);
	}
}
