package pl.norb.CarFactory.repository;

import java.util.ArrayList;
import java.util.List;

import pl.norb.CarFactory.model.Dealer;

public class DealerRepository {

	List<Dealer> dealers;

	public List<Dealer> getDealers() {
		return dealers;
	}

	public DealerRepository() {
		dealers = new ArrayList<>();
		Dealer dealerOne = new Dealer();
		Dealer dealerTwo = new Dealer();
		Dealer dealerThree = new Dealer();
		dealerOne.setIdDealer(1);
		dealerTwo.setIdDealer(2);
		dealerThree.setIdDealer(3);
		dealerOne.setNameDealer("KazekCar");
		dealerTwo.setNameDealer("SebaAuto");
		dealerThree.setNameDealer("MotoJozwa");
		dealers.add(dealerOne);
		dealers.add(dealerTwo);
		dealers.add(dealerThree);
	}

	public Dealer getDealer(int id) {
		for (Dealer dealer : dealers)
			if (dealer.getIdDealer() == id) {
				return dealer;
			}
		return null;
	}

	public void createDealer(Dealer dealer) {
		dealers.add(dealer);

	}
}
