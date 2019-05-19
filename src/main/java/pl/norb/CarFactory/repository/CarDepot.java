package pl.norb.CarFactory.repository;

import java.util.ArrayList;
import java.util.List;

import pl.norb.CarFactory.model.Car;

public class CarDepot {

	List<Car> cars = new ArrayList<>();
	OptionRepository optionRepository = new OptionRepository();
	EquipmentRepository equipmentRepositories = new EquipmentRepository();
	CarRepository carRepository = new CarRepository();

	public CarDepot() {
		Car hondaCivicNo1 = new Car();
		hondaCivicNo1.setIdCar(11);
		hondaCivicNo1.setBrandCar("Honda");
		hondaCivicNo1.setModelCar("Civic");
		hondaCivicNo1.setColorCar("black");
		hondaCivicNo1.setOption(optionRepository.getOption(111));
		hondaCivicNo1.setEquipments(equipmentRepositories.getEquipments());
		hondaCivicNo1.setStatusCar("Ordered");
		Car hondaCivicNo2 = new Car();
		hondaCivicNo2.setIdCar(12);
		hondaCivicNo2.setBrandCar("Honda");
		hondaCivicNo2.setModelCar("Civic");
		hondaCivicNo2.setColorCar("white");
		hondaCivicNo2.setOption(optionRepository.getOption(112));
		hondaCivicNo2.setEquipments(equipmentRepositories.equipments.subList(0, 2));
		hondaCivicNo2.setStatusCar("To order");
		Car hondaCrvNo3 = new Car();
		hondaCrvNo3.setIdCar(13);
		hondaCrvNo3.setBrandCar("Honda");
		hondaCrvNo3.setModelCar("CRV");
		hondaCrvNo3.setColorCar("white");
		hondaCrvNo3.setOption(optionRepository.getOption(113));
		hondaCrvNo3.setEquipments(equipmentRepositories.equipments.subList(2, 3));
		hondaCrvNo3.setStatusCar("In process");
		Car hondaHrvNo4 = new Car();
		hondaHrvNo4.setIdCar(14);
		hondaHrvNo4.setBrandCar("Honda");
		hondaHrvNo4.setModelCar("HRV");
		hondaHrvNo4.setColorCar("White");
		hondaHrvNo4.setOption(optionRepository.getOption(113));
		hondaHrvNo4.setEquipments(equipmentRepositories.equipments.subList(1, 2));
		hondaHrvNo4.setStatusCar("Ordered");

		cars.add(hondaCivicNo1);
		cars.add(hondaCivicNo2);
		cars.add(hondaCrvNo3);
		cars.add(hondaHrvNo4);

	}

	public List<Car> getAllCars() {
		return cars;
	}

	public Car getCarFromDepo(int carId) {
		for (Car car : cars)
			if (car.getIdCar() == carId) {
				return car;
			}

		return null;
	}

	public Car orderCar(int id) {
		for (Car car : cars)
			if ((!car.getStatusCar().equals("ordered")) && (car.getIdCar() == id)) {
				car.setStatusCar("Ordered");
				return car;
			}
		return null;
	}

	public void addToProduction(Car car) {
		cars.add(car);

	}

}
