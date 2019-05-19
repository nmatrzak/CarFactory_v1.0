package pl.norb.CarFactory.model;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder(value = { "idOption", "engine", "transmission" })
public class OptionCar {

	private int idOption;
	private String engine;
	private String transmission;
	List<Link> links = new ArrayList<>();

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public int getIdOption() {
		return idOption;
	}

	public void setIdOption(int idOption) {
		this.idOption = idOption;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public void addLink(String url, String rel, String type) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		link.setType(type);
		links.add(link);
	}
}
