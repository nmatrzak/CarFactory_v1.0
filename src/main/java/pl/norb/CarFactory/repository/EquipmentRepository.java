package pl.norb.CarFactory.repository;

import java.util.ArrayList;
import java.util.List;

import pl.norb.CarFactory.model.Equipment;

public class EquipmentRepository {

	List<Equipment> equipments;

	public EquipmentRepository() {
		equipments = new ArrayList<>();
		Equipment equipmentOne = new Equipment();
		Equipment equipmentTwo = new Equipment();
		Equipment equipmentThree = new Equipment();
		equipmentOne.setIdEquipment(11);
		equipmentTwo.setIdEquipment(12);
		equipmentThree.setIdEquipment(13);
		equipmentOne.setNameEquipment("klimatyzacja");
		equipmentTwo.setNameEquipment("radio");
		equipmentThree.setNameEquipment("zlote klamki");
		equipments.add(equipmentOne);
		equipments.add(equipmentTwo);
		equipments.add(equipmentThree);
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public Equipment getEquipment(int id) {
		for (Equipment equipment : equipments)
			if (equipment.getIdEquipment() == id) {
				return equipment;
			}
		return null;
	}

	public void createEquipment(Equipment equipment) {
		equipments.add(equipment);
	}
}
