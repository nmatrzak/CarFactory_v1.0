package pl.norb.CarFactory.model;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder(value = { "idCar", "brandCar", "modelCar", "colorCar", "option", "equipments", "statusCar",
		"links" })
public class Car {

	private int idCar;
	private String brandCar;
	private String modelCar;
	private String colorCar;
	private OptionCar option;
	private List<Equipment> equipments;
	private String statusCar;
	List<Link> links = new ArrayList<>();

	public String getStatusCar() {
		return statusCar;
	}

	public void setStatusCar(String statusCar) {
		this.statusCar = statusCar;
	}

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	public String getBrandCar() {
		return brandCar;
	}

	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}

	public String getModelCar() {
		return modelCar;
	}

	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}

	public String getColorCar() {
		return colorCar;
	}

	public void setColorCar(String colorCar) {
		this.colorCar = colorCar;
	}

	public OptionCar getOption() {
		return option;
	}

	public void setOption(OptionCar option) {
		this.option = option;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public void addLink(String url, String rel, String type) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		link.setType(type);
		links.add(link);
	}
}
