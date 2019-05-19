package pl.norb.CarFactory.model;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder(value = { "idEquipment", "nameEquipment" })
public class Equipment {

	private int idEquipment;
	private String nameEquipment;

	List<Link> links = new ArrayList<>();

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public Equipment() {

	}

	public Equipment(int idEquipment, String nameEquipment) {
		this.idEquipment = idEquipment;
		this.nameEquipment = nameEquipment;
	}

	public int getIdEquipment() {
		return idEquipment;
	}

	public void setIdEquipment(int idEquipment) {
		this.idEquipment = idEquipment;
	}

	public String getNameEquipment() {
		return nameEquipment;
	}

	public void setNameEquipment(String nameEquipment) {
		this.nameEquipment = nameEquipment;
	}

	public void addLink(String url, String rel, String type) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		link.setType(type);
		links.add(link);
	}
}
