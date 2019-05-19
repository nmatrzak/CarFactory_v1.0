package pl.norb.CarFactory.repository;

import java.util.ArrayList;
import java.util.List;

import pl.norb.CarFactory.model.OptionCar;

public class OptionRepository {

	List<OptionCar> optoionCars;

	public OptionRepository() {

		optoionCars = new ArrayList<>();
		OptionCar basic = new OptionCar();
		OptionCar medium = new OptionCar();
		OptionCar supreme = new OptionCar();
		basic.setIdOption(111);
		medium.setIdOption(112);
		supreme.setIdOption(113);
		basic.setEngine("1.5");
		medium.setEngine("2.0");
		supreme.setEngine("5.0");
		basic.setTransmission(" 4_manual");
		medium.setTransmission("6_manual");
		supreme.setTransmission("automatic");

		optoionCars.add(basic);
		optoionCars.add(medium);
		optoionCars.add(supreme);

	}

	public List<OptionCar> getOptions() {
		return optoionCars;
	}

	public OptionCar getOption(int id) {
		for (OptionCar optionCar : optoionCars)
			if (optionCar.getIdOption() == id) {
				return optionCar;
			}
		return null;
	}

	public void createOption(OptionCar optionCar) {
		optoionCars.add(optionCar);
	}
}
