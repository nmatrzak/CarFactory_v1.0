package pl.norb.CarFactory.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import pl.norb.CarFactory.model.OptionCar;
import pl.norb.CarFactory.repository.OptionRepository;

@Path("options")
public class OptionResources {

	OptionRepository optionRepo = new OptionRepository();

	@GET
	@Consumes("text/plain,text/html")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<OptionCar> getAllOptions(@Context UriInfo uriInfo) {
		List<OptionCar> optionCars = optionRepo.getOptions();
		for (OptionCar optionCar : optionCars) {
			String uri1 = uriInfo.getAbsolutePathBuilder().build().toString();
			optionCar.addLink(uri1, "self", "GET");
			String uri2 = uriInfo.getBaseUriBuilder().path(OptionResources.class)
					.path(Integer.toString(optionCar.getIdOption())).build().toString();
			optionCar.addLink(uri2, "option", "GET");
		}
		return optionRepo.getOptions();
	}

	@GET
	@Path("{id}")
	@Consumes("text/plain,text/html")
	@Produces({ MediaType.APPLICATION_JSON })
	public OptionCar getOption(@PathParam("id") int id, @Context UriInfo uriInfo) {
		OptionCar optionCar = optionRepo.getOption(id);
		String uri = uriInfo.getAbsolutePathBuilder().toString();
		optionCar.addLink(uri, "self", "GET");
		return optionRepo.getOption(id);

	}
}
