package pl.norb.CarFactory.model;

import javax.ws.rs.core.Link;

public class Dealer {

	private int idDealer;
	private String nameDealer;
	private Link link;

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	public int getIdDealer() {
		return idDealer;
	}

	public void setIdDealer(int idDealer) {
		this.idDealer = idDealer;
	}

	public String getNameDealer() {
		return nameDealer;
	}

	public void setNameDealer(String nameDealer) {
		this.nameDealer = nameDealer;
	}

}
