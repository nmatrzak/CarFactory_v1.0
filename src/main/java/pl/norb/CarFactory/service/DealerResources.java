package pl.norb.CarFactory.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pl.norb.CarFactory.model.Dealer;

import pl.norb.CarFactory.repository.DealerRepository;

@Path("dealers")
public class DealerResources {

	DealerRepository dealerRepository = new DealerRepository();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Dealer> getAllDealers() {

		return dealerRepository.getDealers();
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Dealer getDealer(@PathParam("id") int id) {
		return dealerRepository.getDealer(id);
	}
}
