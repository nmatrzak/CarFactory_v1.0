package pl.norb.CarFactory.repository;

import java.util.ArrayList;
import java.util.List;

import pl.norb.CarFactory.model.Car;

public class CarRepository {

	List<Car> producedCars = new ArrayList<>();
	OptionRepository optionRepository = new OptionRepository();
	EquipmentRepository equipmentRepositories = new EquipmentRepository();

	public CarRepository() {
		Car hondaCivicNo1 = new Car();
		hondaCivicNo1.setIdCar(1);
		hondaCivicNo1.setBrandCar("Honda");
		hondaCivicNo1.setModelCar("Civic");
		hondaCivicNo1.setColorCar("Black");
		hondaCivicNo1.setOption(optionRepository.getOption(111));
		hondaCivicNo1.setEquipments(equipmentRepositories.getEquipments());

		Car hondaCivicNo2 = new Car();
		hondaCivicNo2.setIdCar(2);
		hondaCivicNo2.setBrandCar("Honda");
		hondaCivicNo2.setModelCar("Civic");
		hondaCivicNo2.setColorCar("white");
		hondaCivicNo2.setOption(optionRepository.getOption(112));
		hondaCivicNo2.setEquipments(equipmentRepositories.equipments.subList(0, 2));

		Car hondaCrvNo3 = new Car();
		hondaCrvNo3.setIdCar(3);
		hondaCrvNo3.setBrandCar("Honda");
		hondaCrvNo3.setModelCar("CRV");
		hondaCrvNo3.setColorCar("white");
		hondaCrvNo3.setOption(optionRepository.getOption(113));
		hondaCrvNo3.setEquipments(equipmentRepositories.equipments.subList(2, 3));

		Car hondaHrvNo4 = new Car();
		hondaHrvNo4.setIdCar(4);
		hondaHrvNo4.setBrandCar("Honda");
		hondaHrvNo4.setModelCar("HRV");
		hondaHrvNo4.setColorCar("White");
		hondaHrvNo4.setOption(optionRepository.getOption(111));
		hondaHrvNo4.setEquipments(equipmentRepositories.equipments.subList(1, 2));

		Car hondaHrvNo5 = new Car();
		hondaHrvNo5.setIdCar(5);
		hondaHrvNo5.setBrandCar("Honda");
		hondaHrvNo5.setModelCar("HRV");
		hondaHrvNo5.setColorCar("Red");
		hondaHrvNo5.setOption(optionRepository.getOption(113));
		hondaHrvNo5.setEquipments(equipmentRepositories.equipments.subList(1, 1));

		Car hondaHrvNo6 = new Car();
		hondaHrvNo6.setIdCar(6);
		hondaHrvNo6.setBrandCar("Honda");
		hondaHrvNo6.setModelCar("HRV");
		hondaHrvNo6.setColorCar("Black");
		hondaHrvNo6.setOption(optionRepository.getOption(112));
		hondaHrvNo6.setEquipments(equipmentRepositories.equipments.subList(0, 1));

		producedCars.add(hondaCivicNo1);
		producedCars.add(hondaCivicNo2);
		producedCars.add(hondaCrvNo3);
		producedCars.add(hondaHrvNo4);
		producedCars.add(hondaHrvNo5);
		producedCars.add(hondaHrvNo6);
	}

	public List<Car> getAllProducedCars() {
		return producedCars;
	}

	public Car getCarToProduction(int carId) {
		for (Car car : producedCars)
			if (car.getIdCar() == carId) {
				car.setStatusCar("To produce");
				return car;
			}
		return null;
	}
}
